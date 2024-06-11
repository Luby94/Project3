<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/header.css" />

<style>

.spanImg {
	border: 1px solid #ccc;
	width: 90px;
	height: 70px;
}

.flight-wrapper {
    margin-bottom: 20px;
}

.flight-header {
    display: flex;
    align-items: center;
}

.flight-logo {
    text-align: center;
    margin-right: 20px;
}

.flight-logo img {
    display: block;
    margin: 0 auto;
}

.flight-logo em {
    display: block;
    margin-top: 5px;
}

.flight-details-wrapper {
    flex-grow: 1;
}

.flight-details {
    margin: 10px 0;
}

.flight-details ul {
    list-style-type: none;
    padding: 0;
}

.flight-details li {
    border: 1px solid #ccc;
    padding: 10px;
    margin-bottom: 10px;
}

.flight-details span {
    display: inline-block;
    margin-right: 10px;
}

.flight-details em {
    font-style: normal;
    font-weight: bold;
}

</style>

</head>

<%@include file="/WEB-INF/include/header.jsp"%>
<%@include file="/WEB-INF/include/nav.jsp"%>

<body>
    <c:forEach items="${roundTripFlights}" var="roundTrip">
        <div class="flight-wrapper">
            <div class="flight-header">
                <span class="flight-logo">
                    <img src="${ roundTrip[0].LOGO }" class="spanImg" alt="logo">
                    <em>${ roundTrip[0].AIRLINE_NAME }</em>
                </span>
                <div class="flight-details-wrapper">
                    <c:forEach items="${roundTrip}" var="flight">
                        <div class="flight-details">
                            <ul>
                                <li>
                                    <div>
                                        <span>
                                            <span>${ flight.START_TIME }
                                                <em>${ flight.DEPCITY_ENAME }
                                                    <span>
                                                        <span>${ flight.DEPCITY_NAME }</span>
                                                    </span>
                                                </em>
                                            </span>
                                        </span>
                                        <span>→</span>
                                        <span>
                                            <em>${ flight.DURATIONHOUR }시간 ${ flight.DURATIONMINUTE }분</em>
                                        </span>
                                        <span>
                                            <span>${ flight.END_TIME }</span>
                                            <span>
                                                <em>${ flight.ARRCITY_ENAME }
                                                    <span>${ flight.ARRCITY_NAME }</span>
                                                </em>
                                            </span>
                                        </span>
                                        <span>직항</span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <hr/> <!-- 왕복 항공편 구분선 -->
    </c:forEach>

	
<%@include file="/WEB-INF/include/footer.jsp"%>

</body>
</html>