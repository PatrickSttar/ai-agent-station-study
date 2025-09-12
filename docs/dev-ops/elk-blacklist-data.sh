#!/bin/bash

# Script to write mock group-buy blacklist data to Elasticsearch.
# Usage: ./elk-blacklist-data.sh

# Elasticsearch Configuration
ES_HOST="localhost:9200"
INDEX_NAME="group-buy-market-log-$(date +%Y.%m.%d)"

# Color Output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${GREEN}Starting to write mock blacklist data to Elasticsearch...${NC}"
echo -e "${YELLOW}Target Index: ${INDEX_NAME}${NC}"
echo -e "${YELLOW}ES Host: ${ES_HOST}${NC}"

# Check Elasticsearch Connection
echo "Checking Elasticsearch connection..."
if ! curl -s "http://${ES_HOST}/_cluster/health" > /dev/null; then
    echo -e "${RED}Error: Cannot connect to Elasticsearch (${ES_HOST})${NC}"
    echo "Please ensure Elasticsearch is running."
    exit 1
fi
echo -e "${GREEN}Elasticsearch connection successful${NC}"

# Mock User Data
USERS=("user001" "user002" "user003" "user004" "user005" "user006" "user007" "user008" "user009" "user010")
IPS=("192.168.1.100" "192.168.1.101" "192.168.1.102" "10.0.0.50" "10.0.0.51" "172.16.0.100" "172.16.0.101" "203.0.113.10" "203.0.113.11" "198.51.100.20")
USER_AGENTS=("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X)" "Mozilla/5.0 (Android 10; Mobile)" "Mozilla/5.0 (Windows NT 10.0; Win64; x64)" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)")
GROUP_BUY_PRODUCTS=("product_001" "product_002" "product_003" "product_004" "product_005")
LIMIT_REASONS=("High Frequency" "Malicious Orders" "Abnormal IP" "Daily Limit Exceeded" "Blacklisted User")
LIMIT_TYPES=("rate_limit" "frequency_limit" "ip_blacklist" "daily_limit" "user_blacklist")

# Generate random timestamp within the last 24 hours
generate_timestamp() {
    local now=$(date +%s)
    local random_offset=$((RANDOM % 86400))
    local timestamp=$((now - random_offset))
    date -d "@$timestamp" -Iseconds
}

# Generate random log level
generate_log_level() {
    local levels=("ERROR" "WARN" "INFO")
    echo "${levels[$((RANDOM % ${#levels[@]}))]}"
}

# Generate mock rate limit log data
generate_log_data() {
    local user_id="${USERS[$((RANDOM % ${#USERS[@]}))]}"
    local ip="${IPS[$((RANDOM % ${#IPS[@]}))]}"
    local user_agent="${USER_AGENTS[$((RANDOM % ${#USER_AGENTS[@]}))]}"
    local product="${GROUP_BUY_PRODUCTS[$((RANDOM % ${#GROUP_BUY_PRODUCTS[@]}))]}"
    local limit_reason="${LIMIT_REASONS[$((RANDOM % ${#LIMIT_REASONS[@]}))]}"
    local limit_type="${LIMIT_TYPES[$((RANDOM % ${#LIMIT_TYPES[@]}))]}"
    local timestamp=$(generate_timestamp)
    local log_level=$(generate_log_level)
    local request_count=$((RANDOM % 100 + 50))
    local limit_threshold=$((RANDOM % 50 + 20))

    cat << EOF
{
  "@timestamp": "${timestamp}",
  "level": "${log_level}",
  "logger": "com.fuzhengwei.security.RateLimitFilter",
  "thread": "http-nio-8080-exec-$((RANDOM % 10 + 1))",
  "message": "User access limited - UserID: ${user_id}, Product: ${product}, Reason: ${limit_reason}, IP: ${ip}, Requests: ${request_count}, Threshold: ${limit_threshold}",
  "application": "group-buy-market",
  "environment": "production",
  "service": "group-buy-service",
  "user_id": "${user_id}",
  "ip_address": "${ip}",
  "user_agent": "${user_agent}",
  "product_id": "${product}",
  "limit_type": "${limit_type}",
  "limit_reason": "${limit_reason}",
  "request_count": ${request_count},
  "limit_threshold": ${limit_threshold},
  "action": "blocked",
  "endpoint": "/api/group-buy/join",
  "method": "POST",
  "status_code": 429,
  "response_time": $((RANDOM % 100 + 10)),
  "session_id": "session_$(date +%s)_${RANDOM}",
  "trace_id": "trace_$(date +%s)_${RANDOM}",
  "tags": ["limit", "blacklist", "group-buy", "security"]
}
EOF
}

# Bulk write data
echo "Generating and writing mock data..."
for i in {1..50}; do
    echo -n "Writing record $i... "

    # Generate log data
    log_data=$(generate_log_data)

    # Write to Elasticsearch
    response=$(curl -s -X POST "http://${ES_HOST}/${INDEX_NAME}/_doc" \
        -H "Content-Type: application/json" \
        -d "$log_data")

    # Check write result
    if echo "$response" | grep -q '"result":"created"'; then
        echo -e "${GREEN}Success${NC}"
    else
        echo -e "${RED}Failed${NC}"
        echo "Response: $response"
    fi

    # Random delay to simulate real world scenario
    sleep 0.$((RANDOM % 5 + 1))
done

echo -e "${GREEN}Data writing complete!${NC}"
echo "Checking index info:"
curl -s "http://${ES_HOST}/${INDEX_NAME}/_count" | jq .

echo -e "${YELLOW}You can use the following command to view the data:${NC}"
echo "curl -X GET \"http://${ES_HOST}/${INDEX_NAME}/_search?pretty&size=5\""
echo -e "${YELLOW}Or check the index in Kibana: ${INDEX_NAME}${NC}"