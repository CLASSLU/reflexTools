package main;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.obj.B;
import test.obj.D;
import test.obj.FormatInterface;
import test.obj.toListInterface;
import tool.dataformat.DataFormatUitl;
import tool.obj2list.Object2ListUtil;
import tool.objectcomputed.ObjectComputedUtil;
import tool.objectoperation.ObjectUtil;
import tool.objectvaluereplace.ObjectValueReplaceUtill;

public class Main {

	public static void main(String[] args) throws Exception {
//		format();

//		szys();
		
//		o2l();
		
		attSetTest();
		
//		cloneTest();
		
//		thTest();
		
	}

	//对象属性赋值测试
	public static void attSetTest() {
		D d= new D();
		
		ObjectUtil.set(d, "a", null);
//		ObjectOperationUtil.set(d, "A", 2);
		ObjectUtil.set(d, "aA", 3);
		ObjectUtil.set(d, "Aa", 4);
		ObjectUtil.set(d, "AA", 5);
		
		//对象中包含属性 a 与 A, get set方法重合 
		System.out.println("a = "+ ObjectUtil.get(d, "a", Integer.class));
		System.out.println("A = "+ ObjectUtil.get(d, "A", Integer.class));
		System.out.println("aA = "+ ObjectUtil.get(d, "aA", Integer.class));
		System.out.println("Aa = "+ ObjectUtil.get(d, "Aa", Integer.class));
		System.out.println("AA = "+ ObjectUtil.get(d, "AA", Integer.class));
		
		Map<String, String> map = new HashMap<>();
		
		
		ObjectUtil.set(map, "哈哈", "不好");
		ObjectUtil.set(map, "1", "2");
		
		for(String key : map.keySet()){
			System.out.println(key.toString() +"= "+ ObjectUtil.get(map, key));
		}
	}

	/**
	 * 数值格式化测试
	 */
	public static FormatInterface format(){
		B a = new B();
		a.setAge(999999);
		a.setName("李四");
		// a.setSex(false);
		a.setD(333.33);
		a.setMbig(new BigDecimal("9.9"));
		// a.setMbyte((byte)10);
		// a.setMchar('x');
		 a.setMfloat(44f);
		// // a.setMint(100);
		a.setMlong(1234567890l);
		// a.setMshort((short)50);
		a.setDate(new Date());
		
		FormatInterface f = DataFormatUitl.newInstance(a, FormatInterface.class);
		System.out.println(f.getMlong());
		System.out.println(f.getDate());
		System.out.println(f.getMfloat());
		return f;
	}
	
	/**
	 * 四则运算测试
	 */
	public static void szys() {
		B b = new B();
		b.setAge(10);
		b.setName("张三");
		b.setSex(false);
		b.setD(10.00);
		b.setMbig(new BigDecimal("666"));
//		b.setMbig(null);
		b.setMbyte((byte) 10);
		b.setMchar('x');
		b.setMfloat(4.44f);
		b.setMint(100);
		b.setMlong(2000l);
		b.setMshort((short) 50);

		B b1 = new B();
		b1.setAge(999999);
		b1.setName("李四");
		b1.setSex(false);
		b1.setD(333.33);
		b1.setMbig(new BigDecimal("9.9"));
//		a.setMbig(null);
		 b1.setMbyte((byte)10);
		 b1.setMchar('x');
		 b1.setMfloat(4.44f);
		  b1.setMint(100);
		b1.setMlong(2000l);
		 b1.setMshort((short)50);
		b1.setDate(new Date());
		
		B c =new B();
		c.setSex(false);
		c.setD(333.33);
		c.setMbig(new BigDecimal("9.9"));
//		a.setMbig(null);
		 c.setMbyte((byte)10);
		 c.setMchar('x');
		 c.setMfloat(4.44f);
		  c.setMint(100);
		c.setMlong(2000l);
		 c.setMshort((short)50);
		c.setDate(new Date());
		
		
		// 对象四则运算
		System.out.println("+   " + ObjectComputedUtil.add( b1, b));
		
		Object o= new Object(); 
		System.out.println("-   " + ObjectComputedUtil.subtract(true,b1, c));
		
		System.out.println("*   " + ObjectComputedUtil.multiply(b1, b, true, Integer.class));
		System.out.println("/   " + ObjectComputedUtil.divide(b1, b, true));
	}
	
	/**
	 * 对象转数组测试
	 */
	public static void o2l() {
		B a = new B();
		a.setAge(999999);
		a.setName("李四");
		// a.setSex(false);
		a.setD(333.33);
		a.setMbig(new BigDecimal("9.9"));
		// a.setMbyte((byte)10);
		// a.setMchar('x');
		 a.setMfloat(44f);
		// // a.setMint(100);
		a.setMlong(1234567890l);
		// a.setMshort((short)50);
		a.setDate(new Date());
		
		List<Object> list = Object2ListUtil.toList(format(),toListInterface.class);
		System.out.println(list);
	}
	
	public static void cloneTest() throws Exception{
		B a = new B();
		a.setAge(999999);
		a.setName("李四");
		 a.setSex(false);
		a.setD(333.33);
		a.setMbig(new BigDecimal("9.9"));
		 a.setMbyte((byte)10);
		 a.setMchar('x');
		 a.setMfloat(44f);
		  a.setMint(100);
		a.setMlong(1234567890l);
		 a.setMshort((short)50);
		a.setDate(new Date());
		
		B b = a.clone();
		b.setAge(1111);
		b.setName("李");
		 b.setSex(true);
		b.setD(444.33);
		b.setMbig(new BigDecimal("8.9"));
		 b.setMbyte((byte)11);
		 b.setMchar('y');
		 b.setMfloat(55f);
		  b.setMint(101);
		b.setMlong(17890l);
		 b.setMshort((short)40);
		b.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-01-01"));
		
		System.err.println(a);
		System.err.println(b);
	}
	
	/**
	 * 属性值替换
	 */
	public static void thTest(){
		B b = new B();
		
		b.setAge(10);
		b.setName("张三");
		b.setSex(false);
		b.setD(0.0);
		b.setMbig(new BigDecimal("666"));
		b.setMbig2(new BigDecimal("0"));
		b.setMbyte((byte) 0);
		b.setMchar('x');
		b.setMfloat(4.44f);
		b.setMint(100);
		b.setMlong(2000l);
		b.setMshort((short) 50);
		
		System.out.println(b);
		
//		ObjectValueReplaceUtill.execute(b, "x", "15");
		
		b = ObjectValueReplaceUtill.execute(b, "false", null);
		b = ObjectValueReplaceUtill.execute(b, null, "true",Boolean.class);
		
		System.out.println(b);
	}
}
