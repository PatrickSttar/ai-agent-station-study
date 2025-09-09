package cn.bugstack.ai.infrastructure.dao;

import cn.bugstack.ai.infrastructure.dao.po.AiAgentFlowConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAiAgentFlowConfigDao {
    /**
     * 插入智能体-客户端关联配置
     * @param aiAgentFlowConfig 智能体-客户端关联配置对象
     * @return 影响行数
     */
    int insert(AiAgentFlowConfig aiAgentFlowConfig);
    /**
     * 根据ID 更新智能体-客户端关联配置
     * @param aiAgentFlowConfig 智能体-客户端关联配置对象
     * @return 影响行数
     */
    int updateById(AiAgentFlowConfig aiAgentFlowConfig);
    /**
     * 根据ID 删除智能体-客户端关联配置
     * @param id 主键 id
     * @return 影响行数
     */
    int deleteById(Long id);
    /**
     * 根据智能体ID 删除智能体-客户端关联配置
     * @param agentId 智能体ID
     * @return 影响行数
     */
    int deleteByAgentId(Long agentId);
    /**
     * 根据ID 查询智能体-客户端关联配置
     * @param id 主键 id
     * @return 智能体-客户端关联配置对象
     */
    AiAgentFlowConfig queryById(Long id);
    /**
     * 根据智能体ID 查询智能体-客户端关联配置
     * @param agentId 智能体ID
     * @return 智能体-客户端关联配置对象列表
     */
    List<AiAgentFlowConfig> queryByAgentId(Long agentId);
    /**
     * 根据客户端ID 查询智能体-客户端关联配置
     * @param clientId 客户端ID
     * @return 智能体-客户端关联配置对象列表
     */
    List<AiAgentFlowConfig> queryByClientId(Long clientId);
    /**
     * 根据智能体ID 和 客户端ID 查询智能体-客户端关联配置
     * @param agentId 智能体ID
     * @param clientId 客户端ID
     * @return 智能体-客户端关联配置对象
     */
    AiAgentFlowConfig queryByAgentIdAndClientId(Long agentId, Long clientId);
    /**
     * 查询所有智能体-客户端关联配置
     * @return 智能体-客户端关联配置对象列表
     */
    List<AiAgentFlowConfig> queryAll();

}
