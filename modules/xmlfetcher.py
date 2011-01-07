#!/usr/bin/env python
#
# Copyright Jifeng Zhang <zjfroot@gmail.com>.
#
#
import urllib2

from google.appengine.api import memcache

class XmlFetcher:
    def __init__(self, source, section):
        self.source = source
        self.section = section
        
    def get(self):
        #First try to load the xml from cache
        key = self.source + '_' +self.section
        xml = memcache.get(key)
        
        #If found, return the xml, otherwise download from news provider's rss url
        if xml is not None:
            return xml
        else:
            xml = self.__download()
            memcache.add(key,xml,600)
            return xml

    #download from rss    
    def __download(self):
        if self.source == "dn":
            if self.section == "top":
                url = "http://www.dn.se/m/rss/senaste-nytt"
        
        try:
            response = urllib2.urlopen(url)
            result = response.read()
            return result
        except urllib2.URLError, e:
            return "error"