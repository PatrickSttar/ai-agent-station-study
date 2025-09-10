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
public class AiClientVO {
    /**
     * 客户端 ID
     */
    private String clientId;
    /**
     * 客户端名称
     */
    private String clientName;
    /**
     * 客户端描述
     */
    private String description;
    /**
     * 全局唯一模型ID
     */
    private String modelId;
    /**
     * Prompt ID List
     */
    private List<String> promptIdList;
    /**
     * MCP ID List
     */
    private List<String> mcpIdList;
    /**
     * 顾问 ID List
     */
    private List<String> advisorIdList;


}
