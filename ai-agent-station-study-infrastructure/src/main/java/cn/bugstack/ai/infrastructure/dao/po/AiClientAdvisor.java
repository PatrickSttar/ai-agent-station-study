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
public class AiClientAdvisor {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 客户端ID
     */
    private Long clientId;
    /**
     * 顾问ID
     */
    private String advisorId;
    /**
     * 顾问名称
     */
    private String advisorName;
    /**
     * 顾问类型
     */
    private String advisorType;
    /**
     * 顺序号
     */
    private Integer orderNum;
    /**
     * 扩展参数配置，json记录
     */
    private String extParam;
    /**
     * 状态
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
