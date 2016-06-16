package cloud_analysis_test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;

import cn.tarena.ca.pojo.DataByHours;
import cn.tarena.ca.util.JSONUtil;

/**
 * 测试利用Echarts-Java工具画折线图
 * 
 * @author wuyw
 *
 */
public class LineTest10 {
	

	@Test
	public void test() {
		GsonOption option = new GsonOption();
		option.title().text("浏览量(PV)");
		option.title().subtext("趋势图");

		option.legend().data("今天", "昨天", "近7天", "近30天");

		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
				Tool.restore, Tool.saveAsImage);
		option.tooltip().trigger(Trigger.axis).formatter("{a} <br/>{b} : {c}");

		option.yAxis(new ValueAxis());
		
		CategoryAxis categoryAxis = new CategoryAxis();
		categoryAxis.name("x");
		categoryAxis.data("00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00");

		option.xAxis(categoryAxis);

		Line line = new Line("今天");
		String[] data = {"18", "39", "9", "27", "-", "27", "41", "23", "69"} ;
		line.data(data);
		Line line2 = new Line("昨天");
		line2.data(19, 32, 24, 48, 16, 32, 64, 28, 56);
		Line line3 = new Line("近7天");
		line3.data(24, 34, 54, 32, 65, 36, 64, 23, 43);
		Line line4 = new Line("近30天");
		line4.data(44, 14, 84, 22, 45, 16, 94, 23, 33);
		option.series(line, line2, line3, line4);
		System.out.println(option.toPrettyString());
	}
}