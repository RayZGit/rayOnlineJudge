package com.yupi.rayoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.rayoj.model.dto.question.QuestionQueryRequest;
import com.yupi.rayoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.rayoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.rayoj.model.entity.Question;
import com.yupi.rayoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.rayoj.model.entity.User;
import com.yupi.rayoj.model.vo.QuestionSubmitVO;
import com.yupi.rayoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param request
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param request
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, HttpServletRequest request);

}
