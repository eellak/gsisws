<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xalan="http://xml.apache.org/xalan"
	exclude-result-prefixes="xalan">
	<xsl:output method="xml" indent="yes"  xalan:indent-amount="2"/>
	
	<xsl:param name="replace-development-token" select="'http://localhost:8080/gsisws/services/GsisService'"/>
	
	<xsl:template match="@*|node()"> 
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="@location">
		<xsl:attribute name="location">
			<xsl:value-of select="$replace-development-token"/>
		</xsl:attribute>
	</xsl:template>
</xsl:stylesheet>