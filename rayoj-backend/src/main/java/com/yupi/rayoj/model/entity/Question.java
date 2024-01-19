package com.yupi.rayoj.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目
 * @TableName question
 */
@TableName(value ="question")
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 提交数
     */
    private Integer submitNum;

    /**
     * 通过数
     */
    private Integer acceptNum;

    /**
     * 判题用例 json数组
     */
    private String judgeCase;

    /**
     * 判题配置 json对象
     */
    private String judgeConfig;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

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

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 标签列表（json 数组）
     */
    public String getTags() {
        return tags;
    }

    /**
     * 标签列表（json 数组）
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 题目答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 题目答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 提交数
     */
    public Integer getSubmitNum() {
        return submitNum;
    }

    /**
     * 提交数
     */
    public void setSubmitNum(Integer submitNum) {
        this.submitNum = submitNum;
    }

    /**
     * 通过数
     */
    public Integer getAcceptNum() {
        return acceptNum;
    }

    /**
     * 通过数
     */
    public void setAcceptNum(Integer acceptNum) {
        this.acceptNum = acceptNum;
    }

    /**
     * 判题用例 json数组
     */
    public String getJudgeCase() {
        return judgeCase;
    }

    /**
     * 判题用例 json数组
     */
    public void setJudgeCase(String judgeCase) {
        this.judgeCase = judgeCase;
    }

    /**
     * 判题配置 json对象
     */
    public String getJudgeConfig() {
        return judgeConfig;
    }

    /**
     * 判题配置 json对象
     */
    public void setJudgeConfig(String judgeConfig) {
        this.judgeConfig = judgeConfig;
    }

    /**
     * 点赞数
     */
    public Integer getThumbNum() {
        return thumbNum;
    }

    /**
     * 点赞数
     */
    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    /**
     * 收藏数
     */
    public Integer getFavourNum() {
        return favourNum;
    }

    /**
     * 收藏数
     */
    public void setFavourNum(Integer favourNum) {
        this.favourNum = favourNum;
    }

    /**
     * 创建用户 id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 创建用户 id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getSubmitNum() == null ? other.getSubmitNum() == null : this.getSubmitNum().equals(other.getSubmitNum()))
            && (this.getAcceptNum() == null ? other.getAcceptNum() == null : this.getAcceptNum().equals(other.getAcceptNum()))
            && (this.getJudgeCase() == null ? other.getJudgeCase() == null : this.getJudgeCase().equals(other.getJudgeCase()))
            && (this.getJudgeConfig() == null ? other.getJudgeConfig() == null : this.getJudgeConfig().equals(other.getJudgeConfig()))
            && (this.getThumbNum() == null ? other.getThumbNum() == null : this.getThumbNum().equals(other.getThumbNum()))
            && (this.getFavourNum() == null ? other.getFavourNum() == null : this.getFavourNum().equals(other.getFavourNum()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getSubmitNum() == null) ? 0 : getSubmitNum().hashCode());
        result = prime * result + ((getAcceptNum() == null) ? 0 : getAcceptNum().hashCode());
        result = prime * result + ((getJudgeCase() == null) ? 0 : getJudgeCase().hashCode());
        result = prime * result + ((getJudgeConfig() == null) ? 0 : getJudgeConfig().hashCode());
        result = prime * result + ((getThumbNum() == null) ? 0 : getThumbNum().hashCode());
        result = prime * result + ((getFavourNum() == null) ? 0 : getFavourNum().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", tags=").append(tags);
        sb.append(", answer=").append(answer);
        sb.append(", submitNum=").append(submitNum);
        sb.append(", acceptNum=").append(acceptNum);
        sb.append(", judgeCase=").append(judgeCase);
        sb.append(", judgeConfig=").append(judgeConfig);
        sb.append(", thumbNum=").append(thumbNum);
        sb.append(", favourNum=").append(favourNum);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}