<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>БарБосс</title>
  <link href="<s:url value="/resources" />/assets/css/main.css" rel="stylesheet" type="text/css">

</head>

<body onload="loadPage()">
<div id="mainwrapper">
  <header>
    <!--**************************************************************************
    Header starts here. It contains Logo and 3 navigation links.
    ****************************************************************************-->
    <div id="logo">БарБосс</div>
    <nav> <a href="/" title="Link">Главная</a>&nbsp;&nbsp;&nbsp;<a href="/db_editor" title="Link">БД</a>&nbsp;&nbsp;&nbsp;<a href="#" title="Link">?</a> </nav>
  </header>
  <div id="content">
      <sec:authorize access="isFullyAuthenticated()">
      Hello, <sec:authentication property="principal.username" var="current_username" scope="application" />${current_username}!

      </sec:authorize>
      <a href="<c:url value="/logout" />">Logout</a>
    <!-- <div class="notOnDesktop"> -->
      <!-- This search box is displayed only in mobile and tablet laouts and not in desktop layouts -->
    <!--  <input type="text" placeholder="Search">
    </div> -->
    <section id="mainContent">
      <!--************************************************************************
    Main Blog content starts here
    ****************************************************************************-->
      <t:insertAttribute name="content" />
    </section>
    <!--*    <section id="sidebar">
          <!--************************************************************************
        Sidebar starts here. It contains a searchbox, sample ad image and 6 links
        ****************************************************************************-->
    <!--*      <input type="text" placeholder="Search">
          <nav>
            <ul>
              <li><a href="#" title="Link">Link1</a></li>
              <li><a href="#" title="Link">Link2</a></li>
              <li><a href="#" title="Link">Link3</a></li>
              <li><a href="#" title="Link">Link4</a></li>
              <li><a href="#" title="Link">Link5</a></li>
              <li><a href="#" title="Link">Link6</a></li>
            </ul>
          </nav>
        </section>*-->
        <footer>
          <!--************************************************************************
        Footer starts here
        ****************************************************************************-->
        </footer>
  </div>
  <div id="footerbar"><!-- Small footerbar at the bottom --></div>
</div>

<script>
  function viewTab(aThis){
    el = document.getElementById("tab_ed");
    el.style.display=(el.style.display==""?"none":"");
    aThis.innerText = (el.style.display==""?"<<Табель":"Табель>>");
  }

</script>

</body>
</html>
