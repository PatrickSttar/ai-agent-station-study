package cn.bugstack.ai.domain.agent.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangwenhao
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiClientSystemPromptVO {
    /**
     * 系统提示词ID
     */
    private String promptId;
    /**
     * 系统提示词名称
     */
    private String promptName;
    /**
     * 系统提示词内容
     */
    private String promptContent;
    /**
     * 系统提示词描述
     */
    private String description;

}
