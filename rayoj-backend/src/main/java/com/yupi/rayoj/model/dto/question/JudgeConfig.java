package com.yupi.rayoj.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 */
@Data
public class JudgeConfig {

    private Long timeLimit;

    private Long memoryLimit;

    private Long stackLimit;

}
