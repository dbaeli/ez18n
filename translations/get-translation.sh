#!/bin/sh
if [ -z "$1" -o -z "$2"]
then
   echo "Usage $0 <lang> <key>"
   exit 1
fi

LANG=$1
KAY=$2

echo Downloading LANG=$LANG
wget http://api.crowdin.net/api/project/ez18n-demo/download/fr.zip?key=$KEY -O fr.zip

echo Unzip 
TDIR=${LANG}_`date +%s`
mkdir $TDIR
unzip $LANG.zip -d $TDIR

echo Fix package
for FILE in `find $TDIR -name *.properties`
do
 NEWNAME=`dirname $FILE`/`basename -s .properties $FILE`_$LANG.properties
 mv $FILE $NEWNAME
done

cd $TDIR
zip -r ../ez18n_$LANG.zip *

echo prepared ez18n_$LANG.zip
echo Remove $TDIR
