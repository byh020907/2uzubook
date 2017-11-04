<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");
JSONArray keywordArray= (JSONArray) request.getAttribute("KeywordArray");
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
                                    <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
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
                            <input id="licens" name="license" type="text" placeholder="자격증 이름">
                            <input id="date" name="license_date" type="date">
                            <select id="keyword" name="license_keyword">
                                <option value="">키워드 </option>
                                <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
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
                            <input id="ins" name="award" type="text" placeholder="수상 기관">
                            <input id="date" name="award_date" type="date">
                            <select id="keyword" name="award_keyword" >
                                <option value="">키워드</option>
                                <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
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
                            <input id="test" name="test" type="text" placeholder="어학 이름(ex.토익)">
                            <input id="score" name="test" type="text" placeholder="점수">
                            <input id="date" name="test_date" type="date">
                            <select id="keyword" name="test_keyword">
                                <option value="">키워드 </option>
                                <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
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
                        시작<input id="startdate" name="project_date" type="date">
                        종료<input id="enddate" name="project_date" type="date">
                        <textarea rows="5" cols="50"  id="desc" name="project" placeholder="프로젝트 설명" size="50"> </textarea>
                        <select id="keyword" name="test_keyword">
                            <option value="">키워드 </option>
                            <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
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
                        시작<input id="startdate" name="club_date" type="date">
                        종료<input id="enddate" name="club_date" type="date">
                        <textarea id="desc" name="project" placeholder="동아리 설명" size="50"></textarea>
                        <select id="keyword" name="test_keyword">
                            <option value="">키워드 </option>
                            <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
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
                            <%
                            for(int i=0;i<keywordArray.size();i++)
                            {
								JSONObject keyword=(JSONObject)keywordArray.get(i);
							%>
                              <option value="<%=keyword.get("id")%>">
                                  <%=keyword.get("name")%>
                              </option>
                            <% 
                            }
                            %>
                        </select>
                        <input type="button" value="추가" onclick="obj_add(6,this);return false;"> 
                    </div>
                    </div>
                </td>
            </tr>
            
        </tbody>
       <br>
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
                   <div id="volunteer_tag">
                   <div>
                            <input id="volunteer" name="volunteer" type="text" placeholder="봉사 이름">
                            <input id="date" name="volunteer_date" type="date">
                            <select id="keyword" name="volunteer_keyword">
                                <option value="">키워드 </option>
                                <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
                            </select>
                            <input type="button" value="추가" onclick="obj_add(7,this);return false;"> </div>
                	</div>
                </td>
            </tr>
            <tr>
                <th scope="row">독서</th>
                <td style="width:auto;">
                   <div id="reading_tag">
                   <div>
                            <input id="reading" name="reading" type="text" placeholder="책 이름">
                            <input id="date" name="reading_date" type="date">
                            <select id="keyword" name="reading_keyword">
                                <option value="">키워드 </option>
                                <%
                                for(int i=0;i<keywordArray.size();i++)
                                {
									JSONObject keyword=(JSONObject)keywordArray.get(i);
								%>
	                                 <option value="<%=keyword.get("id")%>">
	                                     <%=keyword.get("name")%>
	                                 </option>
                                <% 
                                }
                                %>
                            </select>
                            <input type="button" value="추가" onclick="obj_add(8,this);return false;"> 
                   		</div>         
                  </div>
                </td>
            </tr>            
        </tbody>
       
    </table>
    <!-- modal -->
        <div id="modalLayer">
		  <div class="modalContent">
		    <h4 style="margin-left:3%">입력 오류</h4>
		    <hr>
		    <center>
		    <h5>빈칸이 존재합니다.</h5>
		    </center>
		    <br>
		    <hr>
		    <button type="button" id="delete_modal" style="float:right;">닫기</button>
		  </div>
		</div>
   <footer>
    <button onclick="total_store(); return false;">저장</button>
</footer>
	<script src="js/jquery.min.js"></script>
    <script src="js/modal.js"></script>
    <script>
    var licen_tag;
    var award_tag;
    var club_tag;
    var reading_tag;
    var conference_tag;
    var volunteer_tag;
    var test_tag;
    var project_tag;
    
    var license_array=new Array();
    var award_array=new Array();
    var club_array=new Array();
    var conference_array=new Array();
    var interest_array=new Array();
    var project_array=new Array();
    var reading_array=new Array();
    var test_array=new Array();
    var volunteer_array=new Array();
    
    var modalLayer = $("#modalLayer");
    var modalLink = $(".modalLink");
    var modalCont = $(".modalContent");
    var marginLeft = modalCont.outerWidth()/2;
    var marginTop = modalCont.outerHeight()/2; 
    
    function total_store();
    {
    	var temp=new Object();
    	temp.licenseArr=license_array;
    	temp.awardArr=award_array;
    	temp.clubArr=club_array;
    	temp.conferenceArr=conference_array;
    	temp.interestArr=interest_array;
        temp.projectArr=project_array;
        temp.readingArr=reading_array;
        temp.testArr=test_array;
        temp.volunteerArr=volunteer_array;
    	$.ajax({
            url: '/2uzubook/OneInputStore'
            , type: 'post'
            , data: temp
            , dataType: 'json'
            , success: function (data) {
                location.href='/index.jsp';
            }
            ,error:function(xhr,option,error){
            	alert(xhr.status);
            	alert(error);
            }
        });
    }
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
    function obj_delete(num,obj)
    {
    	var index=$(obj).parent().index();
    	console.log(index);
    	switch(num){
    	case 1:
    		license_array.splice(index,1);
        	console.log(license_array);	
        	break;
    	case 2:
    		award_array.splice(index,1);
        	console.log(award_array);	
        	break;
    	case 3:
    		test_array.splice(index,1);
        	console.log(test_array);	
        	break;
    	case 4:
    		project_array.splice(index,1);
        	console.log(project_array);	
        	break;
    	case 5:
    		club_array.splice(index,1);
        	console.log(club_array);	
        	break;
    	case 6:
    		conference_array.splice(index,1);
        	console.log(conference_array);	
        	break;
    	case 7:
    		volunteer_array.splice(index,1);
        	console.log(volunteer_array);	
        	break;
    	case 8:
    		reading_array.splice(index,1);
        	console.log(reading_array);	
        	break;
    	}
    	
    	$(obj).parent().remove();
    }
    function modal_come()
    {
    	modalLayer.fadeIn("slow");
        modalCont.css({"margin-top" : -marginTop, "margin-left" : -marginLeft});
        $(this).blur();
        return false;
    }
    function obj_add(num,obj)
    {
    	var loc;
    	var find_loc;
		loc=$(obj).parent().parent();
		find_loc=$(obj).parent();
    	
    	switch(num)
    	{
    	case 1:

    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(1,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
    	    loc.append(licen_tag);
    	    if($(find_loc).find('#date').val==null)
    	    {
    	    	modal_come();
    	    }
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#licens').val();
    		jobj.date=$(find_loc).find('#date').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		
    		license_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 2:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(2,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(award_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#award').val();
    		jobj.ins=$(find_loc).find('#ins').val();
    		jobj.date=$(find_loc).find('#date').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		award_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 3:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(3,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(test_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#test').val();
    		jobj.score=$(find_loc).find('#score').val();
    		jobj.date=$(find_loc).find('#date').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		test_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 4:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(4,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(project_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#project').val();
    		jobj.startdate=$(find_loc).find('#startdate').val();
    		jobj.enddate=$(find_loc).find('#enddate').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		jobj.desc=$(find_loc).find('#desc').val();
    		project_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 5:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(5,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(club_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#club').val();
    		jobj.startdate=$(find_loc).find('#startdate').val();
    		jobj.enddate=$(find_loc).find('#enddate').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		jobj.desc=$(find_loc).find('#desc').val();
    		license_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 6:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(6,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(conference_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#conference').val();
    		jobj.date=$(find_loc).find('#date').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		license_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 7:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(7,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(volunteer_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#volunteer').val();
    		jobj.date=$(find_loc).find('#date').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		license_array.push(jobj);
    		console.log(jobj);
    		break;
    	case 8:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(8,this);return false;"><br>'; 
    		$(obj).parent().append(delete_tag);
        	$(obj).remove();
        	
    		loc.append(reading_tag);
    		var jobj=new Object();
    		jobj.name=$(find_loc).find('#reading').val();
    		jobj.date=$(find_loc).find('#date').val();
    		jobj.keyword=$(find_loc).find('#keyword').val();
    		license_array.push(jobj);
    		console.log(jobj);
    		break;
    	}
    }
    </script>
</body>


</html>