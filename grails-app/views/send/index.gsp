<html>
    <head>
        <title>ABC Opendata Send new Item view</title>
        <meta name="layout" content="main"/>
    </head>
    <body>
       <g:form name="sendForm" url="[controller:'send',action:'send']">
       Name: <g:textField name="nameField" value="${params.nameField}"/><br>
       Twitter <g:textField name="twitterField" value="${params.twitterField}" /><br>
       Page <g:textField name="pageField" value="${params.pageField}"></g:textField><br>
       Wikipedia <g:textField name="wikiField" value="${params.wikiField}"></g:textField><br>
       
       <g:radioGroup name="typeField" labels="['None','Person','Data Source']" values="[1,2,3]" >
		<p>${it.label} ${it.radio}</p>
	   </g:radioGroup>
       <br>
       List of tags (separated by comma): <g:textField name="tagsField" value="${params.tagsField}"></g:textField>
       <br>
       <input type="submit" value="Submit" />
       </g:form>
    </body>
</html>