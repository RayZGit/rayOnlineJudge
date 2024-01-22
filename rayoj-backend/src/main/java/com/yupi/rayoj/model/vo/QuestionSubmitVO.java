package com.yupi.rayoj.model.vo;

import cn.hutool.json.JSONUtil;
import com.yupi.rayoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.rayoj.model.entity.QuestionSubmit;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题目提交封装类
 */
@Data
public class QuestionSubmitVO implements Serializable {

    private Long id;
    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交代码
     */
    private String code;

    /**
     * 判题信息 json对象
     */
    private JudgeInfo judgeInfo;

    /**
     * 判题状态
     */
    private Integer status;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private UserVO userVO;
    private QuestionSubmitVO questionSubmitVO;

    private static final long serialVersionUID = 1L;

    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static QuestionSubmit voToObj(QuestionSubmitVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        QuestionSubmit question = new QuestionSubmit();
        BeanUtils.copyProperties(questionVO, question);

        JudgeInfo judgeInfo = questionVO.getJudgeInfo();
        if (judgeInfo != null) {
            question.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        }

        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionSubmitVO objToVo(QuestionSubmit question) {
        if (question == null) {
            return null;
        }
        QuestionSubmitVO questionVO = new QuestionSubmitVO();
        BeanUtils.copyProperties(question, questionVO);

        String judgeInfo = question.getJudgeInfo();
        questionVO.setJudgeInfo(JSONUtil.toBean(judgeInfo, JudgeInfo.class));
        return questionVO;
    }
}