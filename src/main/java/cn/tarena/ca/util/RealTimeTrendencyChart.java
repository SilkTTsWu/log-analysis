package cn.tarena.ca.util;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;

public class RealTimeTrendencyChart {

	/**
	 * 该方法返回实时数据页面所需折线图option
	 * 
	 * @param data
	 *            按要求传入String数组,该数组是用于Echart显示前台具体统计数据的
	 * @return
	 */
	public static GsonOption LineTrendencyChart(String chartName, String[] data_today, String[] data_yestoday,
			String[] data_7daysAgo, String[] data_30daysAgo) {
		GsonOption option = new GsonOption();
		option.title().text(chartName);
		option.title().subtext("趋势图");

		option.legend().data("今天", "昨天", "近7天", "近30天");

	/*	option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
				Tool.restore, Tool.saveAsImage);*/
		option.tooltip().trigger(Trigger.axis).formatter("{a} <br/>{b} : {c}");

		option.yAxis(new ValueAxis());

		CategoryAxis categoryAxis = new CategoryAxis();
		categoryAxis.name("x");
		categoryAxis.data("00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00",
				"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00",
				"21:00", "22:00", "23:00");

		option.xAxis(categoryAxis);

		Line line = new Line("今天");
		line.data(data_today);
		Line line2 = new Line("昨天");
		line2.data(data_yestoday);
		Line line3 = new Line("近7天");
		line3.data(data_7daysAgo);
		Line line4 = new Line("近30天");
		line4.data(data_30daysAgo);
		option.series(line, line2, line3, line4);
		return option;
	}

}
