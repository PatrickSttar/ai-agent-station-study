package cn.bugstack.ai.domain.agent.model.entity;

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
public class ArmoryCommandEntity {
    /**
     * 命令类型 AiAgentEnumVO.getCode
     */
    private String commandType;
    /**
     * 命令索引（clientId, modelId,apiId ...）
     */
    private List<String> commandIdList;

}
