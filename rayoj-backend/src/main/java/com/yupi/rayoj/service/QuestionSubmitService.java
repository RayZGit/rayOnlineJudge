package com.yupi.rayoj.service;

import com.yupi.rayoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.rayoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.rayoj.model.entity.User;

/**
* @author Ray
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-01-17 21:06:08
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 点赞
     *
     * @param request
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest request, User loginUser);
}
