<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1.0">

<title>My Spring Boot Portfolio</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

    <%@ include file="/WEB-INF/views/fragments/lead-content.jsp" %> 
    <%@ include file="/WEB-INF/views/fragments/education.jsp" %> 
    <%@ include file="/WEB-INF/views/fragments/experience.jsp" %> 
    <%@ include file="/WEB-INF/views/fragments/skills.jsp" %> 
    <%@ include file="/WEB-INF/views/fragments/courses.jsp" %> 
    <%@ include file="/WEB-INF/views/fragments/contact.jsp" %> 

    <button onclick="showPopup()" id="btn">Get NASA Picture</button>
    <div id="demo" style="display: none;">
        <button id="close-btn" onclick="hidePopup()">X</button>
        <h2>NASA Astronomy 🌠</h2>
        <div id="result">Click below for a cool picture!</div>
        <button id="btn" onclick="loadNasaPic()">Fetch Picture</button>
    </div>
    
    <script>
        function loadNasaPic() {
            fetch("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY")
                .then(response => response.json())
                .then(data => document.getElementById("result").innerHTML = 
                    "<b>" + data.title + "</b><br><img src='" + data.url + "' width='300'><br>" + data.explanation)
                .catch(() => document.getElementById("result").innerHTML = "Error loading picture.");
        }
    </script>


</body>
</html>
<!--
🎯 1. Profile Summary
📚 2. Technical Skills..
💻 3. Projects
📝 4. Work Experience / Internships..
🏆 5. Certifications..
📖 6. Education..
🔗 7. Links/Contact Info..
📂 8. Downloadable Resume..
-->