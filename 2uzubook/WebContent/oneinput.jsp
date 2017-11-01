<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>
<%

%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/table.css"> 
</head>

<body>
    <div id="leftside" style="margin-right:0">
        <table class="info">
            <thead>
                <tr>
                    <th scope="cols">학생 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"><img src="/images/student/stu6.jpg" class="studentimg"></th>
                    <td>
                        <h2>
							2학년 1반 소프트웨어개발과 <br> 윤정현
						</h2> <strong>jafj4a2@naver.com</strong>
                        <div>
                            <label for="interest">관심분야</label>
                            <input type="button" value="추가">
                            <div>
                                <input id="interest" name="interest" type="text">
                                <select id="keyword" name="club_keyword">
                                    <option value="">키워드 </option>
                                </select>
                            </div>
                        </div>
                    </td>
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
                        <div id="licence_tag">
                        <div>
                            <input id="license" name="license" type="text" placeholder="자격증 이름">
                            <input id="date" name="license_date" type="date">
                            <select id="keyword" name="license_keyword">
                                <option value="">키워드 </option>
                            </select>
                            <input type="button" value="추가" onclick="obj_add(1,this);return false;"> 
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">수상</th>
                    <td style="width:auto;">
                        <div id="award_tag">
                        <div>
                            <input class="text" id="award" name="award" type="text" placeholder="수상한 상">
                            <input id="award" name="award" type="text" placeholder="수상 기관">
                            <input id="date" name="award_date" type="date">
                            <select id="keyword" name="award_keyword" >
                                <option value="">키워드</option>
                            </select>
                            <input type="button" value="추가" onclick="obj_add(2,this);return false;"> 
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">어학</th>
                    <td>
                        <div id="test_tag">
                        <div>
                            <input id="test" name="test" type="text" placeholder="어학 이름">
                            <input id="date" name="test_date" type="date">
                            <select id="keyword" name="test_keyword">
                                <option value="">키워드 </option>
                            </select>
                            <input type="button" value="추가" onclick="obj_add(3,this);return false;"> 
                            </div>
                        </div>
                    </td>
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
                <td style="width:auto;">
                    <div id="project_tag">
                    	<div>
                        <input id="project" name="project" type="text" placeholder="프로젝트 이름">
                        시작<input id="gdate" name="project_date" type="date">
                        종료<input id="gdate" name="project_date" type="date">
                        <textarea rows="5" cols="50"  id="explain" name="project" placeholder="프로젝트 설명" size="50"> </textarea>
                        <select id="keyword" name="test_keyword">
                            <option value="">키워드 </option>
                        </select>
                        <input type="button" value="추가" onclick="obj_add(4,this);return false;"> 
                    	</div>   
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">전공 동아리</th>
                <td style="width:auto;">
                    <div id="club_tag">
                    	<div>
                        <input id="club" name="club" type="text" placeholder="동아리 이름">
                        시작<input id="gdate" name="club_date" type="date">
                        종료<input id="gdate" name="club_date" type="date">
                        <textarea id="explain" name="project" placeholder="동아리 설명" size="50"></textarea>
                        <select id="keyword" name="test_keyword">
                            <option value="">키워드 </option>
                        </select>
                        <input type="button" value="추가" onclick="obj_add(5,this);return false;"> 
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <th scope="row">대외 공모전 참여</th>
                <td>
                <div id="conference_tag">
                    <div>
                        <input id="conference" name="conference" type="text" placeholder="대회 공모전 이름">
                        <input id="date" name="conference_date" type="date">
                        <select id="keyword" name="conference_keyword">
                            <option value="">키워드 </option>
                        </select>
                        <input type="button" value="추가" onclick="obj_add(6,this);return false;"> 
                    </div>
                    </div>
                </td>
            </tr>
            
        </tbody>
       
    </table>
       <table class="major">
        <thead>
            <tr>
                <th scope="cols">기타</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">봉사</th>
                <td style="width:auto;">
                   <div>
                            <input id="volunteer" name="volunteer" type="text" placeholder="봉사 이름">
                            <input id="date" name="volunteer_date" type="date">
                            <select id="keyword" name="volunteer_keyword">
                                <option value="">키워드 </option>
                            </select>
                            <input type="button" value="추가"> </div>
                </td>
            </tr>
            <tr>
                <th scope="row">독서</th>
                <td style="width:auto;">
                   <div>
                            <input id="reading" name="reading" type="text" placeholder="책 이름">
                            <input id="date" name="reading_date" type="date">
                            <select id="keyword" name="reading_keyword">
                                <option value="">키워드 </option>
                            </select>
                            <input type="button" value="추가"> </div>
                </td>
            </tr>            
        </tbody>
       
    </table>
   <footer>
    <button type="submit">저장</button>
</footer>
	<script src="js/jquery.min.js"></script>
    <script>
    var licen_tag;
    var award_tag;
    var club_tag;
    var reading_tag;
    var conference_tag;
    var volunteer_tag;
    var test_tag;
    var project_tag;
    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(this);return false;"><br>'; 
    $("document").ready(function() {
    	 licen_tag=$("#licence_tag").html();
    	 award_tag=$("#award_tag").html();
    	 club_tag=$("#club_tag").html();
    	 reading_tag=$("#reading_tag").html();
    	 conference_tag=$("#conference_tag").html();
    	 volunteer_tag=$("#volunteer_tag").html();
    	 test_tag=$("#test_tag").html();
    	 project_tag=$("#project_tag").html();
	});
    function obj_delete(obj)
    {
    	$(obj).parent().remove();
    }
    function obj_add(num,obj)
    {
    	var loc;
		loc=$(obj).parent().parent();
		$(obj).parent().append(delete_tag);
    	$(obj).remove();
    	
    	switch(num)
    	{
    	case 1:
    		loc.append(licen_tag);
    		break;
    	case 2:
    		loc.append(award_tag);
    		break;
    	case 3:
    		loc.append(test_tag);
    		break;
    	case 4:
    		loc.append(project_tag);
    		break;
    	case 5:
    		loc.append(club_tag);
    		break;
    	case 6:
    		loc.append(conference_tag);
    		break;
    		
    		
    	}
    }
    </script>
</body>


</html>