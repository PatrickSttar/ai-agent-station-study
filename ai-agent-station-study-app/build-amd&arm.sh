# 兼容 amd、arm 构建镜像
 docker buildx build --load --platform linux/amd64,linux/arm64 -t zhangwenhao01/ai-agent-station-study-app:1.0.0 -f ./Dockerfile .