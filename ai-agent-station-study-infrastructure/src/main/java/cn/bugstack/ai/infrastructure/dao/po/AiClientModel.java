package cn.bugstack.ai.infrastructure.dao.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhangwenhao
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiClientModel {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 全局唯一模型ID
     */
    private String modelId;
    /**
     * 关联的API配置ID
     */
    private String apiId;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 模型类型：openai、deepseek、claude
     */
    private String modelType;
    /**
     * 模型状态：0-禁用，1-启用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
