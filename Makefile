#TOP = ../../..
#include $(TOP)/configure/CONFIG

all:
	mvn clean install
	cp target/VisualDCT*.jar .
	ln -s -T `find . -regextype posix-egrep -regex '\./VisualDCT\-[0-9\.]+\.jar'` VisualDCT.jar
 
install:
	cp vdct $(INSTALL_DIR)/.

clean:
	mvn clean
	rm -f VisualDCT*.jar
