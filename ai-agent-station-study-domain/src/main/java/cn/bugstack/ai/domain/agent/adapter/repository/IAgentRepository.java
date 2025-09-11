package cn.bugstack.ai.domain.agent.adapter.repository;

import cn.bugstack.ai.domain.agent.model.valobj.*;

import java.util.List;
import java.util.Map;

public interface IAgentRepository {
    /**
     * 查询客户端 API 列表
     * @param clientIdList 客户端 ID 列表
     * @return 客户端 API 列表
     */
    List<AiClientApiVO> queryAiClientApiVOListByClientIds(List<String> clientIdList);

    /**
     * 查询客户端模型列表
     * @param clientIdList 客户端 ID 列表
     * @return 客户端模型列表
     */
    List<AiClientModelVO> AiClientModelVOByClientIds(List<String> clientIdList);
    /**
     * 查询客户端工具列表
     * @param clientIdList 客户端 ID 列表
     * @return 客户端工具列表
     */
    List<AiClientToolMcpVO> AiClientToolMcpVOByClientIds(List<String> clientIdList);
    /**
     * 查询客户端系统提示词列表
     * @param clientIdList 客户端 ID 列表
     * @return 客户端系统提示词列表
     */
    List<AiClientSystemPromptVO> AiClientSystemPromptVOByClientIds(List<String> clientIdList);
    /**
     * 查询客户端系统提示词 Map
     * @param clientIdList 客户端 ID 列表
     * @return 客户端系统提示词 Map
     */
    Map<String, AiClientSystemPromptVO> queryAiClientSystemPromptMapByClientIds(List<String> clientIdList);
    /**
     * 查询客户端顾问列表
     * @param clientIdList 客户端 ID 列表
     * @return 客户端顾问列表
     */
    List<AiClientAdvisorVO> AiClientAdvisorVOByClientIds(List<String> clientIdList);
    /**
     * 查询客户端列表
     * @param clientIdList 客户端 ID 列表
     * @return 客户端列表
     */
    List<AiClientVO> AiClientVOByClientIds(List<String> clientIdList);
    /**
     * 查询客户端 API 列表
     * @param modelIdList 模型 ID 列表
     * @return 客户端 API 列表
     */
    List<AiClientApiVO> queryAiClientApiVOListByModelIds(List<String> modelIdList);
    /**
     * 查询客户端模型列表
     * @param modelIdList 模型 ID 列表
     * @return 客户端模型列表
     */
    List<AiClientModelVO> AiClientModelVOByModelIds(List<String> modelIdList);

}
