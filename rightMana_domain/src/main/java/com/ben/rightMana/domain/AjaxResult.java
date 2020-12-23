package com.ben.rightMana.domain;

import lombok.Data;

/**
 * 用来承载 ajax 请求返回的数据
 * @TIME: 15:34
 * @AUTHOR: Ben
 */
@Data
public class AjaxResult {
    // ajax 请求完成的情况
    private boolean succ;

    // 具体承载数据的对象
    private Object data;
}
