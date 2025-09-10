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
public class AiClientApiVO {
    /**
     * API ID
     */
    private String apiId;
    /**
     * 基础URL
     */
    private String baseUrl;
    /**
     * API Key
     */
    private String apiKey;
    /**
     * 对话补全路径
     */
    private String completionsPath;
    /**
     * 嵌入向量路径
     */
    private String embeddingsPath;

}
