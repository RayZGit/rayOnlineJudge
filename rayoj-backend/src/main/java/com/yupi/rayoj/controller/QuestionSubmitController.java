package com.yupi.rayoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.rayoj.common.BaseResponse;
import com.yupi.rayoj.common.ErrorCode;
import com.yupi.rayoj.common.ResultUtils;
import com.yupi.rayoj.exception.BusinessException;
import com.yupi.rayoj.exception.ThrowUtils;
import com.yupi.rayoj.model.dto.question.QuestionQueryRequest;
import com.yupi.rayoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.rayoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.rayoj.model.entity.Question;
import com.yupi.rayoj.model.entity.QuestionSubmit;
import com.yupi.rayoj.model.entity.User;
import com.yupi.rayoj.model.vo.QuestionSubmitVO;
import com.yupi.rayoj.model.vo.QuestionVO;
import com.yupi.rayoj.service.QuestionSubmitService;
import com.yupi.rayoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能提交
        final User loginUser = userService.getLoginUser(request);
        long questionId = questionSubmitAddRequest.getQuestionId();
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取当题目提交列表
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/my/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        if (questionSubmitQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, request));

    }

}
