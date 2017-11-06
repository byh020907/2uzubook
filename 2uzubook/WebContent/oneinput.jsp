<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");
JSONArray keywordArray= (JSONArray) request.getAttribute("KeywordArray");

JSONObject jsonObject= (JSONObject) request.getAttribute("JSONObject");

JSONArray licenses=(JSONArray)jsonObject.get("licenses");
JSONArray awards=(JSONArray)jsonObject.get("awards");
JSONArray projects=(JSONArray)jsonObject.get("projects");
JSONArray conferences=(JSONArray)jsonObject.get("conferences");
JSONArray clubs=(JSONArray)jsonObject.get("clubs");
JSONArray reads=(JSONArray)jsonObject.get("readings");
JSONArray volunteers=(JSONArray)jsonObject.get("volunteers");
JSONArray tests=(JSONArray)jsonObject.get("tests");


System.out.println(jsonObject);//log
String name=(String)jsonObject.get("name");
int major=(Integer)jsonObject.get("major");

String majorName=(String)jsonObject.get("majorName");

int student_id=(Integer)jsonObject.get("stu_id");
String gender=(String)jsonObject.get("gender");
String email=(String)jsonObject.get("email");
%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/table.css"> 
    <link rel="stylesheet" href="css/modalStyle.css" />
</head>

<body>
<script>
var license_array=new Array();
var award_array=new Array();
var club_array=new Array();
var conference_array=new Array();
var interest_array=new Array();
var project_array=new Array();
var reading_array=new Array();
var test_array=new Array();
var volunteer_array=new Array();
function license_add(name,date,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.date=date;
	jobj.keyword=keyword;
	
	license_array.push(jobj);
	console.log(license_array);
}
function award_add(name,date,ins,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.date=date;
	jobj.ins=ins;
	jobj.keyword=keyword;
	
	award_array.push(jobj);
	console.log(award_array);
}
function test_add(name,date,ins,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.date=date;
	jobj.ins=ins;
	jobj.keyword=keyword;
	
	test_array.push(jobj);
	console.log(test_array);
}
function project_add(name,startdate,enddate,desc,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.desc=desc;
	jobj.startdate=startdate;
	jobj.enddate=enddate;
	jobj.keyword=keyword;
	
	project_array.push(jobj);
	console.log(project_array);
}
function club_add(name,startdate,enddate,desc,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.startdate=startdate;
	jobj.enddate=enddate;
	jobj.desc=desc;
	jobj.keyword=keyword;
	
	club_array.push(jobj);
	console.log(club_array);
}
function conference_add(name,date,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.date=date;
	jobj.keyword=keyword;
	
	conference_array.push(jobj);
	console.log(conference_array);
}
function volunteer_add(name,date,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.date=date;
	jobj.keyword=keyword;
	
	volunteer_array.push(jobj);
	console.log(volunteer_array);
}
function read_add(name,date,keyword)
{
	var jobj=new Object();
	jobj.name=name;
	jobj.date=date;
	jobj.keyword=keyword;
	
	reading_array.push(jobj);
	console.log(reading_array);
}
</script>
    <div style=" width: 900px; margin: 0 auto;" >
        <table class="info">
            <thead>
                <tr>
                    <th scope="cols">학생 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"><img src="/2uzubook/ImageServlet?studentID=<%=student_id %>&gender=<%=gender%>" class="studentimg"></th>
                    <td>
                        <h2>
							<%=student_id %> <%=majorName %> <br> <%=name %>
						</h2> <strong><%=email%></strong>
                    
                        
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
	                        <%for(int j=0;j<licenses.size();j++){ 
								JSONObject licen=(JSONObject)licenses.get(j);%>
	                        <div>
	                            <input id="licens" name="license" type="text" value=<%=licen.get("name")%> placeholder="자격증 이름">
	                            <input id="date" name="license_date" type="date" value=<%=licen.get("date")%>>
	                            <select id="keyword" name="license_keyword">
	                                <option value=<%=licen.get("keyword_id")%> selected><%=licen.get("keyword")%></option>
	                                
	                            </select>
    	    					<input type="button" value="삭제" onclick="obj_delete(1,this);return false;"><br>
	                            </div>
	                            <script>
	                            var name='<%=licen.get("name")%>';
	                            var date='<%=licen.get("date")%>';
	                            var keyword='<%=licen.get("keyword_id")%>';
	                            	license_add(name,date,keyword);
	                            	
	                            </script>
	                            
	                            <%
	                        		}
	                            %>
	                        	<div id="ta">
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
                        <%for(int j=0;j<awards.size();j++){ 
								JSONObject award=(JSONObject)awards.get(j);%>
								<div>
                            <input class="text" id="award" name="award" type="text" placeholder="수상한 상" value=<%=award.get("name")%>>
                            <input id="ins" name="award" type="text" placeholder="수상 기관" value=<%=award.get("ins")%>>
                            <input id="date" name="award_date" type="date" value=<%=award.get("date")%>>
                            <select id="keyword" name="award_keyword">
                                	<option value=<%=award.get("keyword_id")%> selected><%=award.get("keyword")%></option>
                            </select>
                            <input type="button" value="삭제" onclick="obj_delete(2,this);return false;"><br>
                            </div>
                            <script>
	                            var name='<%=award.get("name")%>';
	                            var date='<%=award.get("date")%>';
	                            var ins='<%=award.get("ins")%>';
	                            var keyword='<%=award.get("keyword_id")%>';
	                            	award_add(name,date,ins,keyword);
	                            	
	                            </script>
                            <%} %>
                        <div id="ta">
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
                        <%for(int j=0;j<tests.size();j++){ 
								JSONObject test=(JSONObject)tests.get(j);%>
                        <div>
                            <input id="test" name="test" type="text" placeholder="어학 이름(ex.토익)" value=<%=test.get("name")%>>
                            <input id="score" name="test" type="text" placeholder="점수" value=<%=test.get("score")%>>
                            <input id="date" name="test_date" type="date" value=<%=test.get("date")%>>
                            <select id="keyword" name="test_keyword">
                                <option value=<%=test.get("keyword_id")%> selected><%=test.get("keyword")%></option>
                            </select>
                            <input type="button" value="삭제" onclick="obj_delete(3,this);return false;"><br>
                            </div>
                            <script>
	                            var name='<%=test.get("name")%>';
	                            var date='<%=test.get("date")%>';
	                            var score='<%=test.get("score")%>';
	                            var keyword='<%=test.get("keyword_id")%>';
	                            	test_add(name,date,score,keyword);
	                            	
	                            </script>
                            <%} %>
                            <div id="ta">
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
                    <%for(int j=0;j<projects.size();j++){ 
								JSONObject project=(JSONObject)projects.get(j);%>
								<div>
                        <input id="project" name="project" type="text" placeholder="프로젝트 이름" value=<%=project.get("name")%>>
                        시작<input id="startdate" name="project_date" type="date" value=<%=(Date)project.get("startDate")%>>
                        종료<input id="enddate" name="project_date" type="date" value=<%=(Date)project.get("endDate")%>>
                        <textarea rows="5" cols="50"  id="desc" name="project" placeholder="프로젝트 설명" size="50"><%=project.get("desc")%></textarea>
                        <select id="keyword" name="test_keyword">
                            <option value=<%=project.get("keyword_id")%> selected><%=project.get("keyword")%></option>
                        </select>
                        <input type="button" value="삭제" onclick="obj_delete(4,this);return false;"><br> 
                    	</div>   
                    	<script>
	                            var name='<%=project.get("name")%>';
	                            var startdate='<%=project.get("startdate")%>';
	                            var enddate='<%=project.get("enddate")%>';
	                            var score='<%=project.get("desc")%>';
	                            var keyword='<%=project.get("keyword_id")%>';
	                            	project_add(name,startdate,enddate,desc,keyword);
	                            	
	                            </script>
                    	<%} %>
                    	<div id="ta">
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
                    <%for(int j=0;j<clubs.size();j++){ 
								JSONObject club=(JSONObject)clubs.get(j);%>
								<div>
                        <input id="club" name="club" type="text" placeholder="동아리 이름" value=<%=club.get("name")%>>
                        시작<input id="startdate" name="club_date" type="date" value=<%=(Date)club.get("startDate")%>>
                        종료<input id="enddate" name="club_date" type="date" value=<%=(Date)club.get("endDate")%>>
                        <textarea id="desc" name="project" placeholder="동아리 설명" size="50"><%=club.get("desc")%></textarea>
                        <select id="keyword" name="test_keyword">
                            <option value=<%=club.get("keyword_id")%> selected><%=club.get("keyword")%></option>
                        </select>
                        <input type="button" value="삭제" onclick="obj_delete(5,this);return false;"><br>  
                        </div>
                        <script>
	                            var name='<%=club.get("name")%>';
	                            var startdate='<%=club.get("startdate")%>';
	                            var enddate='<%=club.get("enddate")%>';
	                            var score='<%=club.get("desc")%>';
	                            var keyword='<%=club.get("keyword_id")%>';
	                            	club_add(name,startdate,enddate,desc,keyword);
	                            	
	                            </script>
                        <%} %>
                    	<div id="ta">
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
                <%for(int j=0;j<conferences.size();j++){ 
								JSONObject conference=(JSONObject)conferences.get(j);%>
								<div>
                        <input id="conference" name="conference" type="text" placeholder="대회 공모전 이름" value=<%=conference.get("name")%>>
                        <input id="date" name="conference_date" type="date" value=<%=conference.get("date")%>>
                        <select id="keyword" name="conference_keyword">
                            <option value=<%=conference.get("keyword_id")%> selected><%=conference.get("keyword")%></option>
                        </select>
                        <input type="button" value="삭제" onclick="obj_delete(6,this);return false;"><br> 
                    </div>
                    <script>
	                            var name='<%=conference.get("name")%>';
	                            var date='<%=conference.get("date")%>';
	                            var keyword='<%=conference.get("keyword_id")%>';
	                            conference_add(name,date,keyword);
	                            </script>
                    <%} %>
                   
                    <div id="ta">
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
                   <%for(int j=0;j<volunteers.size();j++){ 
								JSONObject volunteer=(JSONObject)volunteers.get(j);%>
								 <div>
                            <input id="volunteer" name="volunteer" type="text" placeholder="봉사 이름" value=<%=volunteer.get("name")%>>
                            시작:<input id="date" name="volunteer_date" type="date" value=<%=(Date)volunteer.get("startTime")%>>
                            종료:<input id="date" name="volunteer_date" type="date" value=<%=(Date)volunteer.get("endTime")%>>
                            <select id="keyword" name="volunteer_keyword">
                            <option value=<%=volunteer.get("keyword_id")%> selected><%=volunteer.get("keyword")%></option>
                            </select>
                        <input type="button" value="삭제" onclick="obj_delete(7,this);return false;"><br>
                        </div>
                         <script>
	                            var name='<%=volunteer.get("name")%>';
	                            var date='<%=volunteer.get("date")%>';
	                            var keyword='<%=volunteer.get("keyword_id")%>';
	                            volunteer_add(name,date,keyword);
	                            </script>
                            <%} %>
                   <div id="ta">
                            <input id="volunteer" name="volunteer" type="text" placeholder="봉사 이름">
                            시작:<input id="startTime" name="volunteer_date" type="date">
                            종료:<input id="endTime" name="volunteer_date" type="date">
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
                        <input type="button" value="추가" onclick="obj_add(7,this);return false;"> 
                	</div>
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
		    <button id="delete_modal" style="float:right;">닫기</button>
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
    
    function total_store()
    {
    	var temp=new Object();
    	temp.licenseArr=license_array;
    	temp.awardArr=award_array;
    	temp.clubArr=club_array;
    	temp.conferenceArr=conference_array;
        temp.projectArr=project_array;
        temp.readingArr=reading_array;
        temp.testArr=test_array;
        temp.volunteerArr=volunteer_array;
        
        var temp=JSON.stringify(temp);
        console.log(temp);
    	
        $.ajax({
            url: '/2uzubook/OneInputStore'
            , type: 'post'
            , data: temp
            , dataType: 'json'
            , success: function (data) {
                location.href='/index.jsp';
            }
            ,error:function(xhr,option,error){
            	console.log(temp);
            	alert(xhr.status);
            	alert(error);
            }
        });
    }
    $("document").ready(function() {
    	 licen_tag=$("#licence_tag #ta").html();
    	 licen_tag='<div>'+licen_tag+'</div>';
    	 award_tag=$("#award_tag #ta").html();
    	 award_tag='<div>'+award_tag+'</div>';
    	 club_tag=$("#club_tag #ta").html();
    	 club_tag='<div>'+club_tag+'</div>';
    	 reading_tag=$("#reading_tag").html();
    	 
    	 conference_tag=$("#conference_tag #ta").html();
    	 conference_tag='<div>'+conference_tag+'</div>';
    	 
    	 volunteer_tag=$("#volunteer_tag #ta").html();
    	 volunteer_tag='<div>'+volunteer_tag+'</div>';
    	 
    	 test_tag=$("#test_tag #ta").html();
    	 test_tag='<div>'+test_tag+'</div>';
    	 
    	 project_tag=$("#project_tag #ta").html();
    	 project_tag='<div>'+project_tag+'</div>';
    	 
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
    	case 9:
    		interest_array.splice(index,1);
        	console.log(interest_array);	
        	break;
    	}
    	
    	
    	$(obj).parent().remove();
    }
    function modal_come()
    {
        var modalLayer = $("#modalLayer");
        var modalCont = $(".modalContent");
        var marginLeft = modalCont.outerWidth()/2;
        var marginTop = modalCont.outerHeight()/2; 
    	console.log("modal");
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
    		if($(find_loc).find('#date').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
    	    	$(obj).parent().append(delete_tag);
            	$(obj).remove();
        	    loc.append(licen_tag);
        	   
    	    	var jobj=new Object();
        		jobj.name=$(find_loc).find('#licens').val();
        		jobj.date=$(find_loc).find('#date').val();
        		jobj.keyword=$(find_loc).find('#keyword').val();
        		
        		license_array.push(jobj);
        			
    	    }
    		console.log(jobj);
    		break;
    	case 2:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(2,this);return false;"><br>'; 
    	    if($(find_loc).find('#date').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
	    		$(obj).parent().append(delete_tag);
	        	$(obj).remove();
	        	
	    		loc.append(award_tag);
	    		var jobj=new Object();
	    		jobj.name=$(find_loc).find('#award').val();
	    		jobj.ins=$(find_loc).find('#ins').val();
	    		jobj.date=$(find_loc).find('#date').val();
	    		jobj.keyword=$(find_loc).find('#keyword').val();
	    		
	    		award_array.push(jobj);
    	    }
    		console.log(jobj);
    		break;
    	case 3:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(3,this);return false;"><br>'; 
    	    if($(find_loc).find('#date').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
	    		$(obj).parent().append(delete_tag);
	        	$(obj).remove();
	        	
	    		loc.append(test_tag);
	    		var jobj=new Object();
	    		jobj.name=$(find_loc).find('#test').val();
	    		jobj.score=$(find_loc).find('#score').val();
	    		jobj.date=$(find_loc).find('#date').val();
	    		jobj.keyword=$(find_loc).find('#keyword').val();
	    		test_array.push(jobj);
    	    }
    		console.log(jobj);
    		break;
    	case 4:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(4,this);return false;"><br>'; 
    	    if($(find_loc).find('#startdate').val()=='' || $(find_loc).find('#enddate').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
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
    	    }
    		break;
    	case 5:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(5,this);return false;"><br>'; 
    	    if($(find_loc).find('#startdate').val()=='' || $(find_loc).find('#enddate').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
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
    	    }
    		break;
    	case 6:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(6,this);return false;"><br>'; 
    	    if($(find_loc).find('#date').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
	    		$(obj).parent().append(delete_tag);
	        	$(obj).remove();
	        	
	    		loc.append(conference_tag);
	    		var jobj=new Object();
	    		jobj.name=$(find_loc).find('#conference').val();
	    		jobj.date=$(find_loc).find('#date').val();
	    		jobj.keyword=$(find_loc).find('#keyword').val();
	    		license_array.push(jobj);
	    		console.log(jobj);
    	    }
    		break;
    	case 7:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(7,this);return false;"><br>';
    	    if($(find_loc).find('#date').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
	    		$(obj).parent().append(delete_tag);
	        	$(obj).remove();
	        	
	    		loc.append(volunteer_tag);
	    		var jobj=new Object();
	    		jobj.name=$(find_loc).find('#volunteer').val();
	    		jobj.date=$(find_loc).find('#date').val();
	    		jobj.keyword=$(find_loc).find('#keyword').val();
	    		license_array.push(jobj);
	    		console.log(jobj);
    	    }
    		break;
    	case 8:
    	    var delete_tag='<input type="button" value="삭제" onclick="obj_delete(8,this);return false;"><br>'; 
    	    if($(find_loc).find('#date').val()=='')
    	    {
    	    	modal_come();
    	    }
    	    else
    	    {
	    	    $(obj).parent().append(delete_tag);
	        	$(obj).remove();
	        	
	    		loc.append(reading_tag);
	    		var jobj=new Object();
	    		jobj.name=$(find_loc).find('#reading').val();
	    		jobj.starttime=$(find_loc).find('#startTime').val();
	    		jobj.endtime=$(find_loc).find('#endTime').val();
	    		jobj.keyword=$(find_loc).find('#keyword').val();
	    		license_array.push(jobj);
	    		console.log(jobj);
    	    }
    		break;
    	}
    }
    function input_go(){
		var frm=$('#oneInput');
		console.log('hel');
		frm.submit();
	}
    </script>
</body>


</html>