<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title" type="java.lang.String" required="false" %>
<%@attribute name="bodyClass" type="java.lang.String" required="false" %>
<!DOCTYPE html>
<html>

<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/WEB-INF/views/jsp/common/import-css.jspf"%>
</head>

<body class="${bodyClass}">