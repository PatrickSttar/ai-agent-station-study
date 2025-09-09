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
public class AiClient {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 客户端ID
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
     * 客户端状态
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
