/**
 * Copyright 2013-2015 JEECG (jeecgos@163.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.excel.demo.excel;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

/**
 * 导入返回类
 *
 * @author JEECG
 * @date 2014年6月29日 下午5:12:10
 */
@Data
public class ExcelParseResult<k, v> {


    /**
     * 结果集
     */
    private Map<k, v> map;

    /**
     * 是否存在校验失败
     */
    private boolean verfiyFail;

    /**
     * 数据源
     */
    private Workbook workbook;

    public ExcelParseResult() {

    }
    public ExcelParseResult(Map<k, v> map, boolean verfiyFail, Workbook workbook) {
        this.map = map;
        this.verfiyFail = verfiyFail;
        this.workbook = workbook;
    }

}
