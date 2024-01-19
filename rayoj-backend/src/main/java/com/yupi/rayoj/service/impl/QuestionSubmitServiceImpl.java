package com.yupi.rayoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.rayoj.common.ErrorCode;
import com.yupi.rayoj.exception.BusinessException;
import com.yupi.rayoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.rayoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.rayoj.model.entity.Question;
import com.yupi.rayoj.model.entity.QuestionSubmit;
import com.yupi.rayoj.model.entity.QuestionSubmit;
import com.yupi.rayoj.model.entity.User;
import com.yupi.rayoj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.rayoj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.rayoj.service.QuestionService;
import com.yupi.rayoj.service.QuestionSubmitService;
import com.yupi.rayoj.service.QuestionSubmitService;
import com.yupi.rayoj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Ray
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-01-17 21:06:08
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{

    @Resource
    private QuestionService questionService;

    /**
     * 题目提交
     *
     * @param request
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest request, User loginUser) {
        long questionId = request.getQuestionId();
        String language = request.getLanguage();
        QuestionSubmitLanguageEnum enumByValue = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (enumByValue == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "Programming Lang Error");
        }
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已题目提交
        long userId = loginUser.getId();
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(request.getCode());
        questionSubmit.setLanguage(language);

        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Fault in doQuestionSubmit");
        }
        return questionSubmit.getId();


    }

}




