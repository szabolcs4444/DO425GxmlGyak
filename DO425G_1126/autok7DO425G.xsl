<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">    
                    <xsl:for-each select="autok/auto">
                        <xsl:sort select="ar" order="ascending" />
                        <Rendszam><xsl:value-of select="@rsz" /></Rendszam>         
                        <Ar><xsl:value-of select="ar" /></Ar>     
                    </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>