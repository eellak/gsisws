<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xalan="http://xml.apache.org/xalan"
	exclude-result-prefixes="xalan">
	<xsl:output method="xml" indent="yes"  xalan:indent-amount="2"/>
	
	<xsl:param name="replace-class" select="'org.ellak.gsisws.server.services.GsisServiceImpl'"/>
	
	<xsl:template match="@*|node()"> 
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="operation">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
		<xsl:if test="position() = last()-1">
			<module ref="rampart"/>
			<wsp:Policy wsu:Id="USNToken"
						xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
		    			xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy">
				<wsp:ExactlyOne>
					<wsp:All>
						<sp:SupportingTokens xmlns:sp="http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702">
							<wsp:Policy>
								<sp:UsernameToken sp:IncludeToken="http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702/IncludeToken/AlwaysToRecipient"/>
							</wsp:Policy>
						</sp:SupportingTokens>
						<ramp:RampartConfig xmlns:ramp="http://ws.apache.org/rampart/policy">
							<ramp:passwordCallbackClass>org.ellak.gsisws.server.auth.PasswordCallbackHandler</ramp:passwordCallbackClass>
						</ramp:RampartConfig>
					</wsp:All>
				</wsp:ExactlyOne>
			</wsp:Policy>
		</xsl:if>
	</xsl:template>
	<xsl:template match="parameter[@name = 'ServiceClass']">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>		
			<xsl:value-of select="$replace-class"/>
		</xsl:copy>
	</xsl:template>	
</xsl:stylesheet>