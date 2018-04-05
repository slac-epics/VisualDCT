TOP = .
include $(TOP)/configure/CONFIG

SCRIPTS += VisualDCT.jar
SCRIPTS += vdct
SCRIPTS += flatdb

include $(TOP)/configure/RULES
include $(TOP)/configure/RULES_TOP

VisualDCT.jar:
	$(M2_HOME)/bin/mvn clean install -f $(TOP)/pom.xml
	cp $(TOP)/target/VisualDCT*.jar .
	mv `find . -regextype posix-egrep -regex '\./VisualDCT\-[0-9\.]+\.jar'` VisualDCT.jar

distclean: clean

clean:
	$(M2_HOME)/bin/mvn clean
	rm -f VisualDCT*.jar

