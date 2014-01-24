#!/bin/env/python
import os,time,json,shutil

OUTPUT_DIR='update'

sites = {}

with open('sites.json','r') as json_file:
    sites = json.load(json_file)

print json.dumps(sites,sort_keys=True,indent=4, separators=(',', ': '))

if os.access(OUTPUT_DIR,os.F_OK):
    shutil.rmtree(OUTPUT_DIR)
os.mkdir(OUTPUT_DIR)
os.chdir(OUTPUT_DIR)

for name,urls in sites.iteritems():
    timestamp = time.time() 
    if not os.access(name,os.F_OK):
        os.mkdir(name)
    compositeArtifacts = "<?xml version='1.0' encoding='UTF-8'?>\n\
    <?compositeArtifactRepository version='1.0.0'?>\n\
    <repository name='%s' type='org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository' version='1.0.0'>\n\
      <properties size='1'>\n\
          <property name='p2.timestamp' value='%s'/>\n\
            </properties>\n\
              <children size='%d'>\n" % (name,timestamp,len(urls))
    compositeContent = "<?xml version='1.0' encoding='UTF-8'?>\n\
    <?compositeMetadataRepository version='1.0.0'?>\n\
    <repository name='%s' type='org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository' version='1.0.0'>\n\
      <properties size='1'>\n\
          <property name='p2.timestamp' value='%s'/>\n\
            </properties>\n\
              <children size='%d'>\n" % (name,timestamp,len(urls))
    for url in urls:
       compositeArtifacts +="<child location='%s'/>\n" % url
       compositeContent +="<child location='%s'/>\n" % url
    compositeArtifacts += "</children>\n\
                    </repository>\n"
    compositeContent += "</children>\n\
                    </repository>\n"
    with open(name + '/compositeArtifacts.xml', 'w') as the_file:
      the_file.write(compositeArtifacts)
    with open(name + '/compositeContent.xml', 'w') as the_file:
      the_file.write(compositeContent)
    print "creating redirect : %s" % name

