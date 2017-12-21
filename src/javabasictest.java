import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;

public class javabasictest {
    public static void print(int index, Object obj) {
        System.out.println(String.format("{%d},%s", index, obj.toString()));    //返回字符型表示
    }

    public static void demoOperation() {   //操作符
        print(1, 5 / 2);
        print(2, 5 + 2);
        print(3, 5 * 2);
        print(4, 5 - 2);
        print(5, 5 << 2);
        print(6, 5 >> 2);
        print(7, 5 & 2);
        print(8, 5 | 2);
        print(9, 5 ^ 2);
        print(10, 5 == 2);
        print(11, 5 != 2);

        int a = 2;
        double b = 2.0;
        a += 2;
        a = a + 2;
        print(12, a);
    }

    public static void demoControlflow() {     //控制流
        int score = 65;
        if (score > 80) {
            print(1, "A");

        } else if (score > 60) {
            print(2, "B");
        } else {
            print(3, "C");
        }
        String grade = "B";
        switch (grade) {
            case "A":
                print(4, "score>80");
                break;

            case "B":
                print(5, "(60,80)");
                break;
            default:
                print(6, "(0,60)");
        }
        for(int i=0;i<6;i++){
          if(i==1){
              continue;       //continue 是跳过当次循环
          }
          if(i==5){
              break;           //break 是跳过整个循环
          }
          if(i%2==1){
              print(8,"i%2=1");
          }
          print(7,i);
        }
       String arr="hello";
        for(int c:arr.toCharArray()){
            print(9,c);
        }

        int target=20;
        int current=0;
        while(current<target){
            current+=5;
            print(10,current);
            if(current==10){
                break;
            }
        }
    }

    public static void demoString(){           //关于String,String不可变，StringBuilder和StringBuffer可变
         String str="hello nowcoder";
         print(1,str.indexOf('e'));
         print(2,str.charAt(6));
        print(3,str.codePointAt(1));  //返回1位置符号的asci码
        print(4,str.compareTo("hello mowcoder"));
        print(5,str.compareTo("hello vowcoder"));  //返回第一个不同的地方的ASCII码差距
        print(6,str.concat("!!"));     //末尾加感叹号
        print(7,str.contains("hello"));
        print(8,str.endsWith("xowcoder"));
        print(9,str.startsWith("hello"));
        print(10,str.compareToIgnoreCase("Hello Nowcoder")); //忽略大小写进行比较
        print(11,str.lastIndexOf('o'));   //从后搜索o所在的位置
        print(12,str.toUpperCase());
        print(13,str.replace('o','a'));
        print(14,str.replaceAll("o|a","a"));  //这里可以用一个正则表达式进行替换
        print(15,str.replaceAll("hello","hi"));

        StringBuilder sb=new StringBuilder();           //StringBuilder可变，效率相对较高
        sb.append(true);
        sb.append(1);
        sb.append(2.2);
        print(16,sb);

        print(17,"a"+"b"+String.valueOf(12));




    }
      public static void demoList(){
        List<String> strList=new ArrayList<String>();
        for(int i=0;i<4;i++){
            strList.add(String.valueOf(i));
        }
        print(1,strList);
        List<String> strListB=new ArrayList<String>();
        for(int i=0;i<4;i++){
            strListB.add(String.valueOf(i*i));
        }
        strList.addAll(strListB);
          print(2,strList);
        strList.remove(2);
        print(3,strList);
        strList.remove(String.valueOf(3));
        print(4,strList);
        print(5,strList.get(1));

        Collections.sort(strList);
        print(6,strList);
         Collections.sort(strList, new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return o2.compareTo(o1);
             }
         });
        print(7,strList);
        Collections.reverse(strList);
        print(8,strList);

        int[] arr=new int[]{1,2,3,4};
        print(9,arr[1]);
      }

      public static void demoSet(){
          Set<String>  strSet=new HashSet<String>();
          for(int i=0;i<4;i++){
              strSet.add(String.valueOf(i));
              strSet.add(String.valueOf(i));
              strSet.add(String.valueOf(i));           //HashSet元素不可重复

          }
          print(1,strSet);
          strSet.remove("1");
          print(2,strSet);
          print(3,strSet.contains("4"));
          strSet.addAll(Arrays.asList(new String[]{"a","b","c"}));
          print(4,strSet);

          for(String value:strSet){
              print(5,value);
          }
          print(6,strSet.isEmpty());
          print(7,strSet.size());



      }
      public static void demoKeyValue(){
          Map<String,String> map=new HashMap<>();
          for(int i=0;i<4;i++){
              map.put(String.valueOf(i),String.valueOf(i*2));
          }
          print(1,map);
          for(Map.Entry<String,String> entry:map.entrySet()){
                       print(2,entry.getKey()+":"+entry.getValue());
          }
          print(3,map.keySet());
          print(4,map.values());
          print(5,map.containsKey("2"));
          print(6,map.get("1"));
          map.replace("1","A");
          print(7,map);
      }
    public static void demoException(){
          try{
               print(1,"hello");
                int a =2;
                a=a/0;
                String b=null;
                b.indexOf('a');
          } catch(NullPointerException npe){
              print(3,"npe");
          } catch(Exception e){
              print(4,"Exception");
          }finally {
              print(2,"finally");   //做清理工作
          }
      }
    /*  public static void demoException2() throws Exception {   //可以主动抛，与上述功能相同
          print(1,"hello");
          int a =2;
          a=a/0;
          String b=null;
          b.indexOf('a');
      } */

    public static void demoCommon(){
        Random random=new Random();
        random.setSeed(1);  //设定好种子，他的随机数就不会发生变化
        for(int i=0;i<4;i++){
            print(1,random.nextInt(100));
        }
        List<Integer> array=Arrays.asList(new Integer[]{1,2,3,4,5});
        print(3,array);
        Collections.shuffle(array);      //链表随机顺序
        print(4,array);

        Date date=new Date();
        print(5,date);
        print(6,date.getTime()); //从1970* 到现在的时间差
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        print(7,df.format(date));
        print(8,DateFormat.getDateInstance(DateFormat.FULL).format(date));  //给定的

        print(9,UUID.randomUUID());
        print(10,Math.max(1,2));
        print(11,Math.ceil(2.2));
        print(12,Math.floor(2.5));
        print(13,Math.log(2.71));


    }
    public static Animal getAnimal(int type) {                     //面向接口编程，越往上越好
        //return new Animal("2", 1);
        return new Human("Lei", 22, "CN");
    }
        public static void Class(){
        Talking animal=new Animal("animal",1);         //面向接口编程，越往上越好
        animal.say();
        animal=new Human("limei",11,"china");  //new 的不同则不同
        animal.say();
        }

        public static void array(String[] A){
            List<String> arrs=Arrays.asList(A);
            if(arrs.contains("x")){
               System.out.println(arrs.indexOf("x"));
            }
        }
    public static void main(String[] args) {
        // print(1,"hello world");
       //demoOperation();
        //demoControlflow();
        //demoString();
        //demoList();
        //demoSet();
        //demoKeyValue();
        //demoException();
        /*try{
            demoException2();
        } catch(NullPointerException npe){
            print(3,"npe");
        } catch(Exception e){
            print(4,"Exception");
        }finally {
            print(2,"finally");   //做清理工作
        } */
        //demoCommon();
        //Class();
        String[] A=new String[]{"1","9","x","a"};
        array(A);
    }
}
