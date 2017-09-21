<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.ArrayList"%>
<%!
	class Student {
		String name;
		String major;
		String licences[];
		String str;
		Student(String name, String major , JSONObject licences) {
			this.name = name;
			this.major = major;
			this.licences=new String[licences.size()];
			for(int i=0;i<licences.size();i++)
			{
				str = String.valueOf(i);
				System.out.println(str);
				this.licences[i]=(String)licences.get("licence"+str);	
			}
		}
	}
%>

<%
		request.setCharacterEncoding("UTF-8");
		JSONObject JsonObj = (JSONObject) request.getAttribute("JSONObject");
		System.out.println(JsonObj);
		
		Student student=new Student((String) JsonObj.get("name"), (String) JsonObj.get("major"),(JSONObject)JsonObj.get("licences"));
		
%>
<html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/2uzubook/CSS/table.css"> </head>

<body>
    <div id="leftside">
        <table class="info">
            <thead>
                <tr>
                    <th scope="cols">학생 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"><img src="/2uzubook/Image/student/stu2.jpg" class="studentimg"> </th>
                    <td>
                        <h2>2학년 1반 소프트웨어개발과 <br> 윤정현</h2> 웹해킹
                        <br> 컴퓨터 보안
                        <br> sw 개발 </td>
                </tr>
            </tbody>
        </table>
        <table class="career">
            <thead>
                <tr>
                    <th scope="cols">경력사항</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">자격증</th>
                    <td>
		                   <%
							for(int i=0;i<student.licences.length;i++)
							{
								System.out.println(i);
							%>
								<%=student.licences[i]%>
								<br>
						
							<% 
							}
		                   %>
                   </td>
                </tr>
                <tr>
                    <th scope="row">수상</th>
                    <td>이미지 메이킹 대회 최우수상 수상 (2016.6.2.)
                        <br> 교내 발명품 경진 대회 동상 (2016.10.31.)
                        <br> 국제 수리 창의대회 은상 수상 ( 2016.10. 31.)</td>
                </tr>
                <tr>
                    <th scope="row">대회 공모전</th>
                    <td>2016 스마트 앱 첼린지STAC (2016. 5. 21.)
                        <br>제 2회 국제 수리 과학 창의대회 (2016. 10. 08.)
                        <br>제 1회 NYPC 넥슨 청소년 프로그래밍 대회 (2016. 8. 31.)
                        <br>대한민국 소프트웨어 융합 해카톤 (2016. 9. 1. ~ 2016. 9. 4.)
                        <br>제 1회 충남대학교 동아리 소프트웨어 경진 대회 (2016. 11. 7.)
                        <br>제 1회 교내 꿈 발표 대회(2016. 11. 25)
                        <br>제 2회 국제 수리 과학 창의대회 (2016. 10. 08.)
                        <br>제 1회 NYPC 넥슨 청소년 프로그래밍 대회 (2016. 8. 31.)
                        <br>대한민국 소프트웨어 융합 해카톤 (2016. 9. 1. ~ 2016. 9. 4.)
                        <br>제 1회 충남대학교 동아리 소프트웨어 경진 대회 (2016. 11. 7.)
                        <br>제 1회 교내 꿈 발표 대회(2016. 11. 25)
                        <br>대한민국 소프트웨어 융합 해카톤 (2016. 9. 1. ~ 2016. 9. 4.)
                        <br>대한민국 소프트웨어 융합 해카톤 (2016. 9. 1. ~ 2016. 9. 4.) </td>
                </tr>
                <tr>
                    <th scope="row">어학 </th>
                    <td>교내 영어 타자 인증 240타 (2016. 10.27.)
                        <br> 토익 570점 (2016.10.31.)</td>
                </tr>
            </tbody>
        </table>
    </div>
    <table class="major">
        <thead>
            <tr>
                <th scope="cols">전공활동</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">프로젝트</th>
                <td>
                    <h4>프로젝트1 :  의견충돌을 줄일 수 있는 토론앱 개발 </h4> - 친구들 간에 어플을 통하여 토론할 수 있는 공간을 만듦
                    <h4>프로젝트1 :  의견충돌을 줄일 수 있는 토론앱 개발 </h4> - 친구들 간에 어플을 통하여 토론할 수 있는 공간을 만듦
                    <h4>프로젝트1 :  의견충돌을 줄일 수 있는 토론앱 개발 </h4> - 친구들 간에 어플을 통하여 토론할 수 있는 공간을 만듦
                    <br> - 싸우지 않고 서로 토론을 통해 결과를 합의하는 방법
                    <h4>프로젝트 2: 혼자 밥먹는 사람을 위한 “혼밥” 개발</h4>프로젝트 2: 혼자 밥먹는 사람을 위한 “혼밥” 개발 - 같은 공간에 있는 혼밥사람들을 여럿이 밥을 먹을 수 있는 공간을 만듦</td>
            </tr>
            <tr>
                <th scope="row">전공 동아리</th>
                <td>
                    <h4> NOP (2016.3.2. ~)</h4>-시스템 해킹과 리눅스에 대해 파헤친다! </td>
            </tr>
            <tr>
                <th scope="row">대외 참여</th>
                <td>해킹캠프 (2015. 9. 21)
                    <br> 월드 아이티쇼 참가 (2016. 5. 20)
                    <br> 사이버안전훈련 교육 (2016 . 7. 21 ~ 7.22)
                    <br> 녹색 발명대회 (2016. 6.15)
                    <br> 창의 발명 논술 대회 (2016. 8.29)
                    <br> 대한민국 소프트웨어 융합 해카톤 (2016. 9. 1~ 9.3)
                    <br> 교내 과학 캠프 참여(2016.7.12.)
                    <br> DSM 해커톤 참여 (2016.8.27. ~ 28)
                    <br> 나는 프로그래머다 (2016.06.09.)
                    <br> 마이더스 IT 기업 탐방 (2016.7.08.)
                    <br> 대전 교육 과학원의 금요일의 과학 터치 (2016.4.16.)
                    <br> 스마트 앱 챌린지 특강 (2016.04.08.)
                    <br> 공개 sw 개발자 대회 특강 (2016.04.08.)</td>
            </tr>
        </tbody>
    </table>
</body>

</html>