package cn.bugstack.ai.domain.agent.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhangwenhao
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiClientModelVO {
    /**
     * 模型ID
     */
    private String modelId;
    /**
     * API ID
     */
    private String apiId;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 模型类型 ,openai,deepseek,claude
     */
    private String modelType;
    /**
     * 工具MCP ID列表
     */
    private List<String> toolMcpIds;

}
