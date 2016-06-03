<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="xml"
                encoding="UTF-8"
                indent="yes"
                omit-xml-declaration="yes"
    />

    <xsl:template match="person">

        <xsl:text>\documentclass[12pt, a4paper]{article}
\usepackage{lmodern}
\usepackage{cmap}
\usepackage[utf8]{inputenc}
\usepackage[T1]{fontenc}
\usepackage[czech]{babel}
\usepackage{setspace}
\usepackage{enumitem}
\renewcommand{\familydefault}{\sfdefault}
\setlength\parindent{0pt}
\pagenumbering{gobble}
\begin{document}
        </xsl:text>

        <!-- Name -->
        <xsl:text>\begin{center} \huge \bfseries </xsl:text>

        <!--Pre title-->
        <xsl:if test="personalInfo/preTitle/text() != ''">
            <xsl:value-of select="personalInfo/preTitle"/>
            <xsl:text> </xsl:text>
        </xsl:if>
        <!--Last name-->
        <xsl:value-of select="personalInfo/firstName"/>
        <xsl:text> </xsl:text>
        <!--First name-->
        <xsl:value-of select="personalInfo/lastName"/>
        <!--Post title-->
        <xsl:if test="personalInfo/postTitle/text() != ''">
            <xsl:text>, </xsl:text>
            <xsl:value-of select="personalInfo/postTitle"/>
        </xsl:if>
        <xsl:text>\end{center}</xsl:text>

        <!--Personal Info-->
        <xsl:text>
\setstretch{1.3}
</xsl:text>
        <xsl:value-of select="personalInfo/address/street"/>
        <xsl:text>, </xsl:text>
        <xsl:value-of select="personalInfo/address/postalCode"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="personalInfo/address/city"/>
        <xsl:text>\\
</xsl:text>

        <xsl:for-each select="personalInfo/phones/phone">
            <xsl:value-of select="text()"/>
            <xsl:if test="position() != last()">
                <xsl:text>, </xsl:text>
            </xsl:if>
        </xsl:for-each>
        <xsl:text>\\
</xsl:text>

        <xsl:for-each select="personalInfo/emails/email">
            <xsl:value-of select="text()"/>
            <xsl:if test="position() != last()">
                <xsl:text>, </xsl:text>
            </xsl:if>
        </xsl:for-each>
        <xsl:text>\\
</xsl:text>

        <xsl:text>\setstretch{1.3}</xsl:text>

        <!--Education-->
        <xsl:if test="education[count(*) &gt; 0]">
            <xsl:text>

{\hrulefill \large \bfseries Vzdělání\hrulefill}

\vspace{0.2cm}</xsl:text>
            <xsl:for-each select="education/school">
                <xsl:text>
{\bfseries </xsl:text>
                <xsl:value-of select="dateStart"/>
                <xsl:text> -- </xsl:text>
                <xsl:choose>
                    <xsl:when test="dateEnd/text() != ''">
                        <xsl:value-of select="dateEnd"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>dosud</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:text>}\\</xsl:text>
                <xsl:value-of select="schoolName"/>
                <xsl:text>\\</xsl:text>
                <xsl:if test="fieldOfStudy">
                    <xsl:text>Obor: </xsl:text>
                    <xsl:value-of select="fieldOfStudy"/>
                    <xsl:text>\\</xsl:text>
                </xsl:if>
                <xsl:if test="grade">
                    <xsl:text>Stupeň: </xsl:text>
                    <xsl:value-of select="grade"/>
                    <xsl:text>\\</xsl:text>
                </xsl:if>
                <xsl:if test="position() != last()">
                    <xsl:text> \\</xsl:text>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>

        <!--Employment-->
        <xsl:if test="employments[count(*) &gt; 0]">
            <xsl:text>

{\hrulefill \large \bfseries Praxe\hrulefill}

\vspace{0.2cm}</xsl:text>
            <xsl:for-each select="employments/employment">
                <xsl:text>
{\bfseries </xsl:text>
                <xsl:value-of select="dateStart"/>
                <xsl:text> -- </xsl:text>
                <xsl:choose>
                    <xsl:when test="dateEnd/text() != ''">
                        <xsl:value-of select="dateEnd"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>dosud</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:text>}\\</xsl:text>
                <xsl:value-of select="company"/>
                <xsl:text>\\ Pracovní pozice: </xsl:text>
                <xsl:value-of select="position"/>
                <xsl:if test="description">
                    <xsl:text>\\ Náplň práce: </xsl:text>
                    <xsl:value-of select="description"/>
                </xsl:if>
                <xsl:text>\\</xsl:text>
                <xsl:if test="position() != last()">
                    <xsl:text> \\</xsl:text>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>

        <!--Other Informations-->
        <xsl:if test="languages or skills or certificates">

            <xsl:variable name="languages">
                <xsl:text>{\bfseries Jazykové znalosti:}
    \begin{itemize}[leftmargin=0.5cm,topsep=0cm]
    \setlength\itemsep{-0.2cm}</xsl:text>
                <xsl:for-each select="languages/language">
                    <xsl:text>\item </xsl:text>
                    <xsl:value-of select="languageName"/>
                    <xsl:text>: </xsl:text>
                    <xsl:value-of select="level"/>
                </xsl:for-each>
                <xsl:text>\end{itemize}</xsl:text>
            </xsl:variable>

            <xsl:variable name="skills">
                <xsl:text>{\bfseries Zručnosti:}
    \begin{itemize}[leftmargin=0.5cm,topsep=0cm]
    \setlength\itemsep{-0.2cm}</xsl:text>
                <xsl:for-each select="skills/skill">
                    <xsl:text>\item </xsl:text>
                    <xsl:value-of select="skillName"/>
                    <xsl:text>: </xsl:text>
                    <xsl:value-of select="level"/>
                </xsl:for-each>
                <xsl:text>\end{itemize}</xsl:text>
            </xsl:variable>

            <xsl:variable name="certificates">
                <xsl:text>{\bfseries Certifikáty:}
    \begin{itemize}[leftmargin=0.5cm,topsep=0cm]
    \setlength\itemsep{-0.2cm}</xsl:text>
                <xsl:for-each select="certificates/certificate">
                    <xsl:text>\item </xsl:text>
                    <xsl:value-of select="text()"/>
                </xsl:for-each>
                <xsl:text>\end{itemize}</xsl:text>
            </xsl:variable>

            <xsl:text>

{\hrulefill \large \bfseries Znalosti a dovednosti\hrulefill}

\vspace{0.2cm}</xsl:text>

            <xsl:choose>
                <xsl:when test="skills and languages and certificates">
                    <xsl:text>\begin{minipage}[t]{4cm}</xsl:text>
                    <xsl:value-of select="$skills"/>
                    <xsl:text>\end{minipage}\hfill \begin{minipage}[t]{4cm}</xsl:text>
                    <xsl:value-of select="$languages"/>
                    <xsl:text>\end{minipage}\hfill \begin{minipage}[t]{4cm}</xsl:text>
                    <xsl:value-of select="$certificates"/>
                    <xsl:text>\end{minipage}</xsl:text>
                </xsl:when>
                <xsl:when test="(skills and languages) or (skills and certificates) or (languages and certificates)">
                    <xsl:if test="skills">
                        <xsl:text>\begin{minipage}[t]{6cm}</xsl:text>
                        <xsl:value-of select="$skills"/>
                        <xsl:text>\end{minipage}</xsl:text>
                    </xsl:if>
                    <xsl:if test="languages">
                        <xsl:text>\begin{minipage}[t]{6cm}</xsl:text>
                        <xsl:value-of select="$languages"/>
                        <xsl:text>\end{minipage}</xsl:text>
                    </xsl:if>
                    <xsl:if test="certificates">
                        <xsl:text>\begin{minipage}[t]{6cm}</xsl:text>
                        <xsl:value-of select="$certificates"/>
                        <xsl:text>\end{minipage}</xsl:text>
                    </xsl:if>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:if test="skills">
                        <xsl:value-of select="$skills"/>
                    </xsl:if>
                    <xsl:if test="languages">
                        <xsl:value-of select="$languages"/>
                    </xsl:if>
                    <xsl:if test="certificates">
                        <xsl:value-of select="$certificates"/>
                    </xsl:if>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>

        <xsl:if test="hobbies">
            <xsl:text> \\</xsl:text>
            <xsl:text>

{\hrulefill \large \bfseries Ostatní informace\hrulefill}

\vspace{0.2cm}
{\bfseries Záliby:} </xsl:text>
            <xsl:for-each select="hobbies/hobby">
                <xsl:value-of select="text()"/>
                <xsl:if test="position() != last()">
                    <xsl:text>, </xsl:text>
                </xsl:if>
            </xsl:for-each>
        </xsl:if>


        <xsl:text>
\end{document}</xsl:text>

    </xsl:template>
</xsl:stylesheet>
