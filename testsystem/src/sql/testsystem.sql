/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : testsystem

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 18/07/2019 11:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination`  (
  `examinee_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考生编号即准考证号',
  `testpaper_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷编号',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '题型编号',
  `question_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目内容',
  `question_id` bigint(20) NULL DEFAULT NULL COMMENT '题目编号',
  `question_score` int(11) NULL DEFAULT NULL COMMENT '题目分值',
  `correct_answer` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '正确答案',
  `examinee_answer` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考生的答案',
  `
correct_error` int(11) NULL DEFAULT NULL COMMENT '答对或者答错'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examination
-- ----------------------------
INSERT INTO `examination` VALUES ('10001', 'x100086', 1, '下面的技术中，是客户端脚本语言的是 ：()  A、ASP  B、PHP  C、Perl  D、VBScript', 1, 4, 'D', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 1, '一组选项中可以选择多项的表单元素是：()A、Checkbox  B、Radio  C、Text  D、Textarea', 2, 4, 'A', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 1, '下面哪个函数可以返回当前的日期和时间：(vbscript) ()  A、now  B、date  C、time  D、datetime', 3, 4, 'A', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 1, '下述选项中不属于JDBC基本功能的是：()  A. 与数据库建立连接  B. 提交SQL语句  C. 处理查询结果  D. 数据库维护管理', 4, 4, 'D', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 1, '判断程序运行完毕后，x， y， z值分别为___________()  x = \"11\" + 1  y = \"11\" & 1  z = \"11\" + \"1\"  A、111 111 111  B、12 111 12  C、12 111 111  D、12 12 12', 5, 4, 'C', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 2, '发送电子邮件时（） A通讯双方必须都在场 B电子邮件比人工邮件传送迅速、可靠且范围更广 C电子邮件可以同时发送给多个用户 D在电子邮件中可以发送', 6, 6, 'BCD', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 2, '用户可设置的文件的属性有（）。 A只写 B隐藏 C存档 D只读', 7, 6, 'BCD', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 4, '鼠标的操作有哪五种方法及其功能?', 8, 10, '', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 4, '计算机病毒有哪些传播途径?如何预防计算机病毒?', 9, 10, '', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 4, '程序设计语言的概念?程序设计语言可分为哪几种?', 10, 10, '', NULL, 0);
INSERT INTO `examination` VALUES ('10001', 'x100086', 5, '将一个正整数分解质因数。例如:输入90,打印出90=2*3*3*5。程序分析:对n进行分解质因数,应先找到一个最小的质数k,然后按下述步骤完成:  (1)如果这个质数恰等于n,则说明分解质因数的过程已经结束,打印出即可。  (2)如果n <> k,但n能被k整除,则应打印出k的值,并用n除以k的商,作为新的正整数你n,重复执行第一步。  (3)如果n不能被k整除,则用k+1作为k的值,重复执行第一步。', 11, 20, 'import java.util.*;  public class lianxi04{  public static void main(String[] args) {  Scanner s = new Scanner(System.in);  System.out.print( \"请键入一个正整数: \");  int n = s.nextInt();  int k=2;  System.out.print(n + \"=\" );  while(k <= n) {  if(k == n) {System.out.println(n);break;}  else if( n % k == 0) {System.out.print(k + \"*\");n = n / k; }  else k++;  }  }  }', NULL, 0);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `subjectId` bigint(20) NOT NULL COMMENT '题型ID',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目ID',
  `question` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目内容',
  `answer` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案',
  `state` int(11) NULL DEFAULT NULL COMMENT '题目状态（是否作废）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 146 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 1, 'a+b=8,a=2,b=?)A.1)B.6)C.5)D.4', 'B', 1);
INSERT INTO `question` VALUES (1, 2, '在DHTML中把整个文件的各个元素作为对象处理的技术是： ()  A、HTML  B、CSS  C、DOM  D、Script', 'C', 1);
INSERT INTO `question` VALUES (1, 3, '一组选项中可以选择多项的表单元素是：()A、Checkbox  B、Radio  C、Text  D、Textarea', 'A', 1);
INSERT INTO `question` VALUES (1, 4, '执行完 a=5>3 And \"a\"<\"c\" 语句后，a的值为：()  A、true  B、false  C、1  D、0', 'B', 1);
INSERT INTO `question` VALUES (1, 5, '语句能够实现的作用是:__________ ()  A、定义并创建一个名为name的文件超链接组件  B、定义并创建一个名为name的广告轮显组件  C、定义并创建一个名为name的存取组件  D、定义并创建一个名为name的浏览器性能组件', 'A', 1);
INSERT INTO `question` VALUES (1, 6, '下面哪个函数可以返回当前的日期和时间：(vbscript) ()  A、now  B、date  C、time  D、datetime', 'A', 0);
INSERT INTO `question` VALUES (1, 7, '执行完如下语句后，Sum的值为：()  A、0  B、5  C、15  D、20', 'C', 0);
INSERT INTO `question` VALUES (1, 8, '执行完 a=5 Mod 3 语句后，a的值为：()  A、0  B、2  C、3  D、5', 'B', 0);
INSERT INTO `question` VALUES (1, 9, '若要求VBScript的变量在使用前必须事先定义，则应使用______语句来设置。()  A、Option Explicit  B、Option Base  C、Dim  D、ReDim', 'A', 0);
INSERT INTO `question` VALUES (1, 10, '语句“mid(\"1234567890\"， 3， 3)”的返回值是___________。()  A、345  B、234  C、456  D、7890', 'A', 1);
INSERT INTO `question` VALUES (1, 11, '下列哪一个函数可以将数值型转换为字符串___________()  A、CDate  B、CInt  C、CStr  D、CDbl', 'C', 0);
INSERT INTO `question` VALUES (1, 12, '判断程序运行完毕后，x， y， z值分别为___________()  x = \"11\" + 1  y = \"11\" & 1  z = \"11\" + \"1\"  A、111 111 111  B、12 111 12  C、12 111 111  D、12 12 12', 'C', 0);
INSERT INTO `question` VALUES (1, 13, '执行完strUser = \"12345678\"以后，strUser是___________类型。()  A、整数变量  B、字符串变量  C、布尔型变量  D、单精度变量', 'B', 0);
INSERT INTO `question` VALUES (1, 14, '使用___________语句可以立即从Sub过程中退出。()  A、Exit Sub  B、Exit  C、<\\Sub>  D、Loop', 'A', 0);
INSERT INTO `question` VALUES (1, 15, '下面关于VBScript的命名规则的说法不正确的是___________。()  A、第一个字符必须是数字或字母  B、长度不能超过255个字符  C、名字不能和关键字同名  D、在声明的时候不能声明两次', 'A', 0);
INSERT INTO `question` VALUES (1, 16, 'QueryString获取方法、Form获取方法获取的数据子类型分别是：()  A、数字、字符串  B、字符串、数字  C、字符串、字符串  D、必须根据具体值而定', 'C', 0);
INSERT INTO `question` VALUES (1, 17, '请判断下面程序运行完毕后a的值：  ()  A、0  B、3  C、5  D、8', 'D', 0);
INSERT INTO `question` VALUES (1, 18, '下面的技术中，是客户端脚本语言的是 ：()  A、ASP  B、PHP  C、Perl  D、VBScript', 'D', 0);
INSERT INTO `question` VALUES (1, 19, '如果想统计一个网站的在线人数，应该使用________对象。()  A、Application  B、Request  C、Server  D、Session', 'D', 0);
INSERT INTO `question` VALUES (1, 20, '如果想统计一个浏览者进入本站点以后浏览的页面次数(包括对同一页面的多次浏览)则可以使用________对象。()  A、Application  B、Request  C、Server  D、Session', 'A', 0);
INSERT INTO `question` VALUES (1, 21, '下面哪一个不是JSP本身已加载的基本类?()  A、java.lang.* B、java.io.* C、javax.servlet.* D、javax.servlet.jsp.*', 'B', 0);
INSERT INTO `question` VALUES (1, 22, '以下关于JavaBeans的说法中，错误的是()。  A、JavaBeans是基于JAVA语言的。  B、JavaBeans是JSP的内置对象之一。  C、JavaBeans是一种Java类。  D、JavaBeans是一个可重复使用的软件组件。', 'B', 0);
INSERT INTO `question` VALUES (1, 23, '下面的说法错误的是：()  A Jsp可以处理动态内容和静态内容  B 在Jsp最终会编译成字节码后执行  C 在jsp中可以使用脚本控制Html的标签生成  D Jsp中不能使用//注释Java脚本中的代码', 'D', 0);
INSERT INTO `question` VALUES (1, 24, '下述选项中不属于JDBC基本功能的是：()  A. 与数据库建立连接  B. 提交SQL语句  C. 处理查询结果  D. 数据库维护管理', 'D', 0);
INSERT INTO `question` VALUES (1, 25, 'JSP 页面经过编译之后，将创建一个()  A. applet B. severlet C. application D. exe文件', 'B', 0);
INSERT INTO `question` VALUES (1, 26, '在jsp中，要定义一个方法，需要用到以下()元素。  A.<%=> B. <%>C. <%!>D. <%@>', 'C', 0);
INSERT INTO `question` VALUES (1, 27, 'JSP在WEB服务器上运行结果：()  A.可以在WEB浏览器看到，  B.只能在WEB浏览器看到。  C.可能在WEB浏览器看到，  D.不可能在WEB浏览器看到。', 'A', 0);
INSERT INTO `question` VALUES (1, 28, 'Page指令用于定义JSP文件中的全局属性，下列关于该指令用法的描述不正确的是：()  A. <%@ page=\"\">作用于整个JSP页面。 B. 可以在一个页面中使用多个<%@ page=\"\">指令。 C. 为增强程序的可读性，建议将<%@ page=\"\">指令放在JSP文件的开头，但不是必须的。 D. <%@ page=\"\">指令中的属性只能出现一次。', 'D', 0);
INSERT INTO `question` VALUES (1, 29, '()的范围是从Web应用服务器一开始执行服务一直到Web应用服务器结束服务为止。  A.页内有效 B.请求有效 C.会话有效 D.应用有效', 'D', 0);
INSERT INTO `question` VALUES (1, 30, '选择、在JSP中使用标记时，不会出现的属性是：()  A.name B.property C.value D.以上皆不会出现', 'C', 0);
INSERT INTO `question` VALUES (2, 31, '以下对C语言中的函数描述不正确的有（）。 A:可以嵌套定义，不可以嵌套调用 B:不可以嵌套定义，可以嵌套调用 C:可以嵌套定义，也可以嵌套调用 D:嵌套定义和嵌套调用都不允许', 'ACD', 0);
INSERT INTO `question` VALUES (2, 32, '.WINDOWS中的文件名不能包括以下字符。() A.? B.> C.* D., E.', 'ABCE', 0);
INSERT INTO `question` VALUES (2, 33, '鼠标器有哪几种基本操作()? A.移动 B.单击 C.双击 D.拖动 E.双击右键', 'ABCD', 0);
INSERT INTO `question` VALUES (2, 34, '在WINDOWS98\"开始\"菜单中的\"关闭系统\",其作用可能有()。 A.用于关闭计算机 B.用于重新启动计算机 C.用于退出到DOS状态 D.用于重新登录', 'ABCDE', 0);
INSERT INTO `question` VALUES (2, 35, '数据通信中根据所允许的信息传输方向，可把通信方式分成（BCE）等几种。 A半单工　B单工 C半双工　D双工　E全双工数据通信中根据所允许的信息传输方向，可把通信方式分成（）等几种。 A半单工　B单工 C半双工　D双工　E全双工', 'BCE', 0);
INSERT INTO `question` VALUES (2, 36, '下列（）是未来计算机的发展趋势。 A提高性能 B缩小体积　C减少成本 D与通信技术结合　E与多媒体技术结合', 'ABCDE', 0);
INSERT INTO `question` VALUES (2, 37, '通常数据传输系统由（）等部分组成。 A计算机　B继电器　C交换器 D调制解调器　E多路复用器', 'CDE', 0);
INSERT INTO `question` VALUES (2, 38, '操作系统的主要功能包括（）。 A处理器管理 　B存储管理 C文件管理 D数据库管理　 E设备管理', 'ABCE', 0);
INSERT INTO `question` VALUES (2, 39, '微型计算机的系统总线由（）组成。 A数据总线 　 B输入总线　　C输出总线　　D控制总线　 E地址总线', 'ADE', 0);
INSERT INTO `question` VALUES (2, 40, '一个计算机网络应包含（）等三个主要组成部分 A通信子网　　 B若干主机　　C传输介质　　D通信设备 E通信协议', 'ABE', 0);
INSERT INTO `question` VALUES (2, 41, '计算机病毒的主要特点包括（）。 A传染性　 B封闭性　 C隐蔽性　　D破坏性　　E潜伏性', 'ACDE', 0);
INSERT INTO `question` VALUES (2, 42, '下列说法中，不正确的是（）。 A计算机非正常关机后，ROM中的信息消失 B计算机非正常关机后，RAM中的信息消失 C计算机非正常关机后，ROM与RAM中的信息均消失 D计算机非正常关机后，ROM与RAM中的信息均不消失', 'ACD', 0);
INSERT INTO `question` VALUES (2, 43, '目前常用的网络传输介质有（） A.双绞线 B.50欧电缆 C.光纤 D.微波', 'ABCD', 0);
INSERT INTO `question` VALUES (2, 44, '目前常见的上网方式有（） A.ADSL B.拨号 C.专线 D.无线', 'ACD', 0);
INSERT INTO `question` VALUES (2, 45, 'URL组成（） A检索方式（协议）B计算机服务器名称 C文档目录和文件名D任何随意的检索词', 'ABC', 0);
INSERT INTO `question` VALUES (2, 46, '告诉浏览器（） A怎样去检索文档 B从哪台计算机上检索 C在哪台计算机上大概什么地方可以找到 D在检索之前或之后需要为它做的事', 'ABC', 0);
INSERT INTO `question` VALUES (2, 47, '下列用户的电子邮件地址中，错误的是（） A用户名，用户口令，电子邮箱所在的主机域名 B用户名，用户口令 C用户名，电子邮箱所在的主机域名 D用户口令，电子邮箱所在的主机域名', 'ABD', 0);
INSERT INTO `question` VALUES (2, 48, '发送电子邮件时（） A通讯双方必须都在场 B电子邮件比人工邮件传送迅速、可靠且范围更广 C电子邮件可以同时发送给多个用户 D在电子邮件中可以发送', 'BCD', 0);
INSERT INTO `question` VALUES (2, 49, '信息源可分为（） A模拟信源 B离散信源 C发射信源 D传递信源', 'AB', 0);
INSERT INTO `question` VALUES (2, 50, '通信系统由（）部分组成。 A信息源和收信者 B发送设备 C传输媒介 D接收设备', 'ABCD', 0);
INSERT INTO `question` VALUES (2, 51, '通信系统按照调剂方式分类可分为（） A基带传输 B调制传输 C数字传输 D模拟传输', 'AB', 0);
INSERT INTO `question` VALUES (2, 52, '按传输信号的特征分类，通信系统可分为（） A模拟通信系统 B数字通信系统 C基带通信系统 D调制通信系统', 'AB', 0);
INSERT INTO `question` VALUES (2, 53, '移动通信的发展方向是（） A数字化 B网络化 C微型化 D标准化', 'ACD', 0);
INSERT INTO `question` VALUES (2, 54, '以下是属于计算机输入设备的是（） A键盘 B绘图仪 C扫描仪 D数码相机', 'ACD', 0);
INSERT INTO `question` VALUES (2, 55, '下列属于计算机主要性能指标的是（） A字长 B存储容量C运算速度 D可配置的设备数量', 'ABC', 0);
INSERT INTO `question` VALUES (2, 56, '计算机技术发展的趋势是（） A微型化 B巨型化 C网络化 D多媒体化', 'ABCD', 0);
INSERT INTO `question` VALUES (2, 57, '信息化的文化内涵主要表现在（） A全球性 B技术性 C通融性 D人类性', 'ABCD', 0);
INSERT INTO `question` VALUES (2, 58, '信息安全包括（）几个 A、信息的安全 B、网络安全 C、传递安全 D、系统', 'AD', 0);
INSERT INTO `question` VALUES (2, 59, '信息的表现形式可以是消息、信号、情报或（） A数据B声波C知识D图像', 'AC', 0);
INSERT INTO `question` VALUES (2, 60, '用户可设置的文件的属性有（）。 A只写 B隐藏 C存档 D只读', 'BCD', 0);
INSERT INTO `question` VALUES (3, 61, '冯•诺依曼原理是计算机的唯一工作原理。', '0', 0);
INSERT INTO `question` VALUES (3, 62, '计算机能直接识别汇编语言程序。', '0', 0);
INSERT INTO `question` VALUES (3, 63, '计算机掉电后,ROM中的信息会丢失。', '0', 0);
INSERT INTO `question` VALUES (3, 64, '应用软件的作用是扩大计算机的存储容量。', '0', 0);
INSERT INTO `question` VALUES (3, 65, '操作系统的功能之一是提高计算机的运行速度。', '0', 0);
INSERT INTO `question` VALUES (3, 66, '1GB等于1000MB,又等于1000000KB', '0', 0);
INSERT INTO `question` VALUES (3, 67, '1GB等于1000MB,又等于1000000KB', '0', 0);
INSERT INTO `question` VALUES (3, 68, '输入和输出设备是用来存储程序及数据的装置。', '0', 0);
INSERT INTO `question` VALUES (3, 69, '任何存储器都有记忆能力,其中是信息不会丢失。', '0', 0);
INSERT INTO `question` VALUES (3, 70, '操作系统的功能之一是提高计算机的运行速度。', '0', 0);
INSERT INTO `question` VALUES (3, 71, '通常硬盘安装在主机箱内,因此它属于主存储器。', '0', 0);
INSERT INTO `question` VALUES (3, 72, '运算器是进行算术和逻辑运算的部件,通常称它为CPU。', '0', 0);
INSERT INTO `question` VALUES (3, 73, '十六位字长的计算机是指能计算最大为16位十进制数据的计算机。', '0', 0);
INSERT INTO `question` VALUES (3, 74, '计算机的中央处理器简称为:ALU。', '0', 0);
INSERT INTO `question` VALUES (3, 75, '计算机中最小单位是二进制的一个数位。', '0', 0);
INSERT INTO `question` VALUES (3, 76, '1个字节是由8个二进制数位组成', '1', 0);
INSERT INTO `question` VALUES (3, 77, 'CPU的主要任务是取出指令,解释指令和执行指令。', '1', 0);
INSERT INTO `question` VALUES (3, 78, 'CPU主要由控制器、运算器和若干寄存器组成。', '1', 0);
INSERT INTO `question` VALUES (3, 79, '微机总线主要由数据总线、地址总线、控制总线三类组成。', '1', 0);
INSERT INTO `question` VALUES (3, 80, '在计算机中,1024B称为一个KB。', '1', 0);
INSERT INTO `question` VALUES (3, 81, '文字信息处理时,各种文字符号都是以二进制数的形式存储在计算机中。', '1', 0);
INSERT INTO `question` VALUES (3, 82, '第二代电子计算机的主要元件是晶体管。', '1', 0);
INSERT INTO `question` VALUES (3, 83, '世界上第一台电子计算机诞生于1946年。', '1', 0);
INSERT INTO `question` VALUES (3, 84, '在计算机中,1K个字节大约可以存储1000个汉字。', '1', 0);
INSERT INTO `question` VALUES (3, 85, '1MB就是1024*1024B。', '1', 0);
INSERT INTO `question` VALUES (3, 86, '计算机存储器中的ROM只能读出数据不能写入数据。', '1', 0);
INSERT INTO `question` VALUES (3, 87, 'ROM和RAM的最大区别是,ROM是只读,RAM可读可写。', '1', 0);
INSERT INTO `question` VALUES (3, 88, '内存储器是用来存储正在执行的程序和所需的数据。', '1', 0);
INSERT INTO `question` VALUES (3, 89, '如果按字长来划分,微机可以分为8位机、16位机、32位机和64位机。', '1', 0);
INSERT INTO `question` VALUES (3, 90, '世界上不同型号的计算机工作原理都是冯诺依曼提出的存储程序控制原理。', '1', 0);
INSERT INTO `question` VALUES (3, 91, '微型机的软盘及硬盘比较,硬盘的特点是存取速度快及存储容量大。', '1', 0);
INSERT INTO `question` VALUES (3, 92, '影响个人计算机系统功能的因素除了系统使用哪种位的微处理器外,还有CPU的时钟  频率、CPU主内存容量、CPU所能提供的指令集。', '1', 0);
INSERT INTO `question` VALUES (3, 93, '打印机是一种输出设备。', '1', 0);
INSERT INTO `question` VALUES (3, 94, '显示器是一种输出设备。', '1', 0);
INSERT INTO `question` VALUES (4, 95, '简述计算机的发展情况?', '', 0);
INSERT INTO `question` VALUES (4, 96, '计算机的特点包括哪些?', '', 0);
INSERT INTO `question` VALUES (4, 97, '计算机性能指标有哪些?', '', 0);
INSERT INTO `question` VALUES (4, 98, '简述计算机的应用领域。', '', 0);
INSERT INTO `question` VALUES (4, 99, '简述微型计算机系统的组成。', '', 0);
INSERT INTO `question` VALUES (4, 100, '什么是计算机病毒?计算机病毒有什么特点?', '', 0);
INSERT INTO `question` VALUES (4, 101, '计算机病毒有哪些传播途径?如何预防计算机病毒?', '', 0);
INSERT INTO `question` VALUES (4, 102, '计算机硬件由哪些组成?', '', 0);
INSERT INTO `question` VALUES (4, 103, '显示器的主要指标有哪些?', '', 0);
INSERT INTO `question` VALUES (4, 104, 'CPU的主要性能指标有哪些?主要分为哪三大类?', '', 0);
INSERT INTO `question` VALUES (4, 105, '简述内存储器和外存储器的区别(从作用和特点两方面入手)?', '', 0);
INSERT INTO `question` VALUES (4, 106, '简述RAM和ROM的区别。(流行的内存类型?)', '', 0);
INSERT INTO `question` VALUES (4, 107, '什么是中断?中断经过哪几步?', '', 0);
INSERT INTO `question` VALUES (4, 108, '主机与外围设备之间信息传送的控制方式有哪几种?', '', 0);
INSERT INTO `question` VALUES (4, 109, 'USB接口有哪些优点?', '', 0);
INSERT INTO `question` VALUES (4, 110, '光盘按用途可分为哪两种?', '', 0);
INSERT INTO `question` VALUES (4, 111, '手写输入有哪两部分组成?语音输入设备是怎么样工作的?', '', 0);
INSERT INTO `question` VALUES (4, 112, '鼠标的操作有哪五种方法及其功能?', '', 0);
INSERT INTO `question` VALUES (4, 113, '键盘的接口类型有几种?常见的101键盘可分为哪几个区?', '', 0);
INSERT INTO `question` VALUES (4, 114, '键盘主要键符功能与作用?', '', 0);
INSERT INTO `question` VALUES (4, 115, '鼠标的主要功能是什么?鼠标的主要技术指标是?常见的接口的类型有几种?', '', 0);
INSERT INTO `question` VALUES (4, 116, '扫描仪按扫描原理分为哪几种?主要指标是什么?', '', 0);
INSERT INTO `question` VALUES (4, 117, '打印机的种类有哪些?打印机的分辨率的单位是?打印机的接口类型有哪些?', '', 0);
INSERT INTO `question` VALUES (4, 118, '投影仪的种类有哪些?投影仪的技术指标主要有?', '', 0);
INSERT INTO `question` VALUES (4, 119, '程序设计语言的概念?程序设计语言可分为哪几种?', '', 0);
INSERT INTO `question` VALUES (4, 120, '软件开发者的版权有哪些?什么是软件的许可证?软件的种类分哪几类?它们之间的规定是什么?', '', 0);
INSERT INTO `question` VALUES (4, 121, '算机中汉字的表示用什么编码?汉字编码可分为哪些?常见的输入码有哪些?', '', 0);
INSERT INTO `question` VALUES (4, 122, '何谓启动计算机?启动分哪几种形式?', '', 0);
INSERT INTO `question` VALUES (4, 123, '什么叫主机?什么叫裸机?什么叫外设?', '', 0);
INSERT INTO `question` VALUES (4, 124, '指令和程序有何区别?简述指令的执行过程?', '', 0);
INSERT INTO `question` VALUES (5, 125, '古典问题:有一对兔子,从出生后第3个月起每个月都生一对兔子,小兔子长到第三个月后每个月又生一对兔子,假如兔子都不死,问每个月的兔子总数为多少?', 'public class lianxi01 {\r\n\r\npublic static void main(String[] args) {\r\n\r\nSystem.out.println(\"第1个月的兔子对数: 1\");\r\n\r\nSystem.out.println(\"第2个月的兔子对数: 1\");\r\n\r\nint f1 = 1, f2 = 1, f, M=24;\r\n\r\nfor(int i=3; i<=M; i++) {\r\n\r\nf = f2;\r\n\r\nf2 = f1 + f2;\r\n\r\nf1 = f;\r\n\r\nSystem.out.println(\"第\" + i +\"个月的兔子对数: \"+f2);\r\n\r\n}\r\n\r\n}\r\n\r\n}', 0);
INSERT INTO `question` VALUES (5, 126, '判断101-200之间有多少个素数,并输出所有素数。  程序分析:判断素数的方法:用一个数分别去除2到sqrt(这个数),如果能被整除,则表明此数不是素数,反之是素数。', 'public class lianxi02 {\r\n\r\npublic static void main(String[] args) {\r\n\r\nint count = 0;\r\n\r\nfor(int i=101; i<200; i+=2) {\r\n\r\nboolean b = false;\r\n\r\nfor(int j=2; j<=Math.sqrt(i); j++)\r\n\r\n{\r\n\r\nif(i % j == 0) { b = false; break; }\r\n\r\nelse { b = true; }\r\n\r\n}\r\n\r\nif(b == true) {count ++;System.out.println(i );}\r\n\r\n}\r\n\r\nSystem.out.println( \"素数个数是: \" + count);\r\n\r\n}\r\n\r\n}', 0);
INSERT INTO `question` VALUES (5, 127, '打印出所有的\"水仙花数\",所谓\"水仙花数\"是指一个三位数,其各位数字立方和等于该数本身。例如:153是一个\"水仙花数\",因为153=1的三次方+5的三次方+3的三次方。', 'public class lianxi03 {  public static void main(String[] args) {  int b1, b2, b3;for(int m=101; m<1000; m++) {  b3 = m / 100;  b2 = m % 100 / 10;  b1 = m % 10;  if((b3*b3*b3 + b2*b2*b2 + b1*b1*b1) == m) {  System.out.println(m+\"是一个水仙花数\"); }  }  }  }', 0);
INSERT INTO `question` VALUES (5, 128, '将一个正整数分解质因数。例如:输入90,打印出90=2*3*3*5。程序分析:对n进行分解质因数,应先找到一个最小的质数k,然后按下述步骤完成:  (1)如果这个质数恰等于n,则说明分解质因数的过程已经结束,打印出即可。  (2)如果n <> k,但n能被k整除,则应打印出k的值,并用n除以k的商,作为新的正整数你n,重复执行第一步。  (3)如果n不能被k整除,则用k+1作为k的值,重复执行第一步。', 'import java.util.*;  public class lianxi04{  public static void main(String[] args) {  Scanner s = new Scanner(System.in);  System.out.print( \"请键入一个正整数: \");  int n = s.nextInt();  int k=2;  System.out.print(n + \"=\" );  while(k <= n) {  if(k == n) {System.out.println(n);break;}  else if( n % k == 0) {System.out.print(k + \"*\");n = n / k; }  else k++;  }  }  }', 0);
INSERT INTO `question` VALUES (5, 129, '题目:利用条件运算符的嵌套来完成此题:学习成绩> =90分的同学用A表示,60-89分之间的用B表示,60分以下的用C表示。', 'import java.util.*;  public class lianxi05 {  public static void main(String[] args) {  int x;  char grade;  Scanner s = new Scanner(System.in);  System.out.print( \"请输入一个成绩: \");  x = s.nextInt();  grade = x >= 90 ? \'A\'  : x >= 60 ? \'B\':\'C\';  System.out.println(\"等级为:\"+grade);  }  }', 0);
INSERT INTO `question` VALUES (5, 130, '输入两个正整数m和n,求其最大公约数和最小公倍数。', 'import java.util.*;  public class lianxi06 {  public static void main(String[] args) {  int a ,b,m;  Scanner s = new Scanner(System.in);  System.out.print( \"键入一个整数:\");  a = s.nextInt();  System.out.print( \"再键入一个整数:\");  b = s.nextInt();  deff cd = new deff();  m = cd.deff(a,b);  int n = a * b / m;  System.out.println(\"最大公约数: \" + m);  System.out.println(\"最小公倍数: \" + n);  }  }  class deff{  public int deff(int x, int y) {  int t;  if(x < y) {  t = x;  x = y;  y = t;  }  while(y != 0) {  if(x == y) return x;  else {  int k = x % y;  x = y;  y = k;  }  }  return x;  }', 0);
INSERT INTO `question` VALUES (5, 131, '输入一行字符,分别统计出其中英文字母、空格、数字和其它字符的个数。', 'import java.util.*;  public class lianxi07 {  public static void main(String[] args) {  int digital = 0;  int character = 0;  int other = 0;  int blank = 0;  char[] ch = null;  Scanner sc = new Scanner(System.in);  String s = sc.nextLine();  ch = s.toCharArray();  for(int i=0; i  if(ch >= \'0\' && ch <= \'9\') {  digital ++;  } else if((ch >= \'a\' && ch <= \'z\') || ch > \'A\' && ch <= \'Z\') {  character ++;  } else if(ch == \' \') {  blank ++;  } else {  other ++;  }  }  System.out.println(\"数字个数: \" + digital);  System.out.println(\"英文字母个数: \" + character);  System.out.println(\"空格个数: \" + blank);  System.out.println(\"其他字符个数:\" + other );  }  }', 0);
INSERT INTO `question` VALUES (5, 132, '求s=a+aa+aaa+aaaa+aa...a的值,其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加),几个数相加有键盘控制。', 'import java.util.*;  public class lianxi08 {  public static void main(String[] args) {  long a , b = 0, sum = 0;  Scanner s = new Scanner(System.in);  System.out.print(\"输入数字a的值:\");  a = s.nextInt();  System.out.print(\"输入相加的项数:\");  int n = s.nextInt();  int i = 0;while(i < n) {  b = b + a;  sum = sum + b;  a = a * 10;  ++ i;  }  System.out.println(sum);  }  }', 0);
INSERT INTO `question` VALUES (5, 133, '一个数如果恰好等于它的因子之和,这个数就称为\"完数\"。例如6=1+2+3.编程找出1000以内的所有完数。', 'public class lianxi09 {  public static void main(String[] args) {  System.out.println(\"1到1000的完数有:\");  for(int i=1; i<1000; i++) {  int t = 0;  for(int j=1; j<= i/2; j++) {  if(i % j == 0) {  t = t + j;  }  }  if(t == i) {  System.out.print(i + \" \");  }  }  }', 0);
INSERT INTO `question` VALUES (5, 134, '一球从100米高度自由落下,每次落地后反跳回原高度的一半;再落下,求它在第10次落地时,共经过多少米?第10次反弹多高?', 'public class lianxi10 {  public static void main(String[] args) {  double h = 100,s = 100;  for(int i=1; i<10; i++) {  s = s + h;  h = h / 2;  }  System.out.println(\"经过路程:\" + s);  System.out.println(\"反弹高度:\" + h / 2);  }  }', 0);
INSERT INTO `question` VALUES (5, 135, '有1、2、3、4四个数字,能组成多少个互不相同且无重复数字的三位数?都是多少? ', 'public class lianxi11 {public static void main(String[] args) {  int count = 0;  for(int x=1; x<5; x++) {  for(int y=1; y<5; y++) {  for(int z=1; z<5; z++) {  if(x != y && y != z && x != z) {  count ++;  System.out.println(x*100 + y*10 + z );  }  }  }  }  System.out.println(\"共有\" + count + \"个三位数\");  }  }', 0);
INSERT INTO `question` VALUES (5, 136, '企业发放的奖金根据利润提成。利润(I)低于或等于10万元时,奖金可提10%;利润高于10万元,低于20万元时,低于10万元的部分按10%提成,高于10万元的部分,可可提成7.5%;20万到40万之间时,高于20万元的部分,可提成5%;40万到60万之间时高于40万元的部分,可提成3%;60万到100万之间时,高于60万元的部分,可提成1.5%,高于100万元时,超过100万元的部分按1%提成,从键盘输入当月利润,求应发放奖金总数?', 'import java.util.*;  public class lianxi12 {  public static void main(String[] args) {  double x = 0,y = 0;  System.out.print(\"输入当月利润(万):\");  Scanner s = new Scanner(System.in);  x = s.nextInt();  if(x > 0 && x <= 10) {  y = x * 0.1;  } else if(x > 10 && x <= 20) {  y = 10 * 0.1 + (x - 10) * 0.075;  } else if(x > 20 && x <= 40) {  y = 10 * 0.1 + 10 * 0.075 + (x - 20) * 0.05;  } else if(x > 40 && x <= 60) {  y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (x - 40) * 0.03;  } else if(x > 60 && x <= 100) {  y = 20 * 0.175 + 20 * 0.05 + 20 * 0.03 + (x - 60) * 0.015;  } else if(x > 100) {  y = 20 * 0.175 + 40 * 0.08 + 40 * 0.015 + (x - 100) * 0.01;  }  System.out.println(\"应该提取的奖金是\" + y + \"万\");  }', 0);
INSERT INTO `question` VALUES (5, 137, '一个整数,它加上100后是一个完全平方数,再加上168又是一个完全平方数,请问该数是多少?', 'public class lianxi13 {  public static void main(String[] args) {  for(int x =1; x<100000; x++) {  if(Math.sqrt(x+100) % 1 == 0) {  if(Math.sqrt(x+268) % 1 == 0) {  System.out.println(x + \"加100是一个完全平方数,再加168又是一个完全平方数\");  }  }  }  }  }', 0);
INSERT INTO `question` VALUES (5, 138, '输入某年某月某日,判断这一天是这一年的第几天?', 'import java.util.*;  public class lianxi14 {  public static void main(String[] args) {  int year, month, day;  int days = 0;  int d = 0;  int e;  input fymd = new input();  do {  e = 0;  System.out.print(\"输入年:\");  year =fymd.input();  System.out.print(\"输入月:\");  month = fymd.input();  System.out.print(\"输入天:\");  day = fymd.input();  if (year < 0 || month < 0 || month > 12 || day < 0 || day > 31) {  System.out.println(\"输入错误,请重新输入!\");  e=1 ;  }  }while( e==1);  for (int i=1; i  switch (i) {case 1:  case 3:  case 5:  case 7:  case 8:  case 10:  case 12:  days = 31;  break;  case 4:  case 6:  case 9:  case 11:  days = 30;  break;  case 2:  if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {  days = 29;  } else {  days = 28;  }  break;  }  d += days;  }  System.out.println(year + \"-\" + month + \"-\" + day + \"是这年的第\" + (d+day) + \"天。\"); }  }  class input{  public int input() {  int value = 0;  Scanner s = new Scanner(System.in);  value = s.nextInt();  return value;  }  }', 0);
INSERT INTO `question` VALUES (5, 139, '输入三个整数x,y,z,请把这三个数由小到大输出。', 'import java.util.*;  public class lianxi15 {  public static void main(String[] args) {  input fnc = new input();  int x=0, y=0, z=0;  System.out.print(\"输入第一个数字:\");x = fnc.input();  System.out.print(\"输入第二个数字:\");  y = fnc.input();  System.out.print(\"输入第三个数字:\");  z = fnc.input();  if(x > y) {  int t = x;  x = y;  y = t;  }  if(x > z) {  int t = x;  x = z;  z = t;  }  if(y > z) {  int t = y;  y = z;  z = t;  }  System.out.println( \"三个数字由小到大排列为:\"+x + \" \" + y + \" \" + z); }  }  class input{  public int input() {  int value = 0;  Scanner s = new Scanner(System.in);  value = s.nextInt();  return value;  }  }', 0);
INSERT INTO `question` VALUES (5, 140, '输出9*9口诀。', 'public class lianxi16 {  public static void main(String[] args) {  for(int i=1; i<10; i++) {  for(int j=1; j<=i; j++) {  System.out.print(j + \"*\" + i + \"=\" + j*i + \" \" );  if(j*i<10){System.out.print(\" \");}  }  System.out.println();  }  }  }', 0);
INSERT INTO `question` VALUES (5, 141, '猴子吃桃问题:猴子第一天摘下若干个桃子,当即吃了一半,还不瘾,又多吃了一个第二天早上又将剩下的桃子吃掉一半,又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时,见只剩下一个桃子了。求第一天共摘了多少。', 'public class lianxi17 {  public static void main(String[] args) {  int x = 1;  for(int i=2; i<=10; i++) {  x = (x+1)*2;  }  System.out.println(\"猴子第一天摘了\" + x + \" 个桃子\");  }  }', 0);
INSERT INTO `question` VALUES (5, 142, '两个乒乓球队进行比赛,各出三人。甲队为a,b,c三人,乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比,c说他不和x,z比,请编程序找出三队赛手的名单。', 'public class lianxi18 {  static char[] m = { \'a\', \'b\', \'c\' };  static char[] n = { \'x\', \'y\', \'z\' };  public static void main(String[] args) {  for (int i = 0; i < m.length; i++) {  for (int j = 0; j < n.length; j++) {  if (m[i] == \'a\' && n[j] == \'x\') {  continue;  } else if (m[i] == \'a\' && n[j] == \'y\') {  continue;  } else if ((m[i] == \'c\' && n[j] == \'x\')  || (m[i] == \'c\' && n[j] == \'z\')) {  continue;  } else if ((m[i] == \'b\' && n[j] == \'z\')  || (m[i] == \'b\' && n[j] == \'y\')) {  continue;  } else  System.out.println(m[i] + \" vs \" + n[j]);  }  }  }  }', 0);
INSERT INTO `question` VALUES (4, 144, '1+1=？\r\nA.2 B.3 C.4 D.5', '2', 0);
INSERT INTO `question` VALUES (3, 145, 'a=1,b=2,\r\na>b?', 'x', 0);

-- ----------------------------
-- Table structure for subject_type
-- ----------------------------
DROP TABLE IF EXISTS `subject_type`;
CREATE TABLE `subject_type`  (
  `subjectId` int(11) NOT NULL AUTO_INCREMENT COMMENT '题型编号',
  `subjectType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题型',
  `score` int(11) NULL DEFAULT NULL COMMENT '分值',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `readType` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`subjectId`) USING BTREE,
  INDEX `subject_id`(`subjectId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_type
-- ----------------------------
INSERT INTO `subject_type` VALUES (1, '单选题', 4, '有且只有一个答案1', 0);
INSERT INTO `subject_type` VALUES (2, '多选题', 4, '少选，多选，不选均无分', 0);
INSERT INTO `subject_type` VALUES (3, '判断题', 2, '对的选对，错的选错', 0);
INSERT INTO `subject_type` VALUES (4, '简答题', 11, '运用自己的观点阐述问题', 1);
INSERT INTO `subject_type` VALUES (5, '编程题', 20, '写出一段程序', 1);

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaper_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷编号',
  `subject_type` int(11) NULL DEFAULT NULL COMMENT '题目类型',
  `subject_num` int(11) NULL DEFAULT NULL COMMENT '题目数量',
  `state` int(11) NULL DEFAULT NULL COMMENT '试卷状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES (1, 'x100086', 1, 5, 0);
INSERT INTO `testpaper` VALUES (2, 'x100086', 2, 2, 0);
INSERT INTO `testpaper` VALUES (3, 'x100086', 4, 3, 0);
INSERT INTO `testpaper` VALUES (4, 'x100086', 5, 1, 0);
INSERT INTO `testpaper` VALUES (5, 'x100010', 1, 10, 0);
INSERT INTO `testpaper` VALUES (6, 'x100010', 2, 2, 0);
INSERT INTO `testpaper` VALUES (7, 'x100010', 3, 10, 0);
INSERT INTO `testpaper` VALUES (8, 'x100010', 5, 1, 0);
INSERT INTO `testpaper` VALUES (9, 'x100011', 1, 20, 0);
INSERT INTO `testpaper` VALUES (10, 'x100011', 5, 1, 0);
INSERT INTO `testpaper` VALUES (16, 'x516767', 1, 11, 0);
INSERT INTO `testpaper` VALUES (17, 'x516767', 2, 22, 0);
INSERT INTO `testpaper` VALUES (18, 'x516767', 3, 33, 0);
INSERT INTO `testpaper` VALUES (19, 'x516767', 4, 44, 0);
INSERT INTO `testpaper` VALUES (20, 'x516767', 5, 55, 0);
INSERT INTO `testpaper` VALUES (21, 'x190001', 1, 12, 0);
INSERT INTO `testpaper` VALUES (22, 'x190001', 2, 22, 0);
INSERT INTO `testpaper` VALUES (23, 'x190001', 3, 33, 0);
INSERT INTO `testpaper` VALUES (24, 'x414294', 1, 1, 0);
INSERT INTO `testpaper` VALUES (25, 'x414294', 2, 22, 0);
INSERT INTO `testpaper` VALUES (26, 'x414294', 3, 44, 0);
INSERT INTO `testpaper` VALUES (27, 'x859414', 1, 2, 0);
INSERT INTO `testpaper` VALUES (28, 'x859414', 2, 3, 0);
INSERT INTO `testpaper` VALUES (29, 'x859414', 4, 3, 0);
INSERT INTO `testpaper` VALUES (30, 'x859414', 5, 33, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考号',
  `password` varchar(26) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `testpaperId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷编号',
  `state` int(11) NULL DEFAULT NULL COMMENT '考试状态0为未开始',
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10001', '123', '张三', 'x100086', 1, 1);
INSERT INTO `user` VALUES ('10002', '123', '李四', '', 0, 0);
INSERT INTO `user` VALUES ('10003', '123', '王五', '', 0, NULL);
INSERT INTO `user` VALUES ('10004', NULL, '赵六', '', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
