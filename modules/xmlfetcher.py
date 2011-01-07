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
        #generate the key that represent which news source to fetch.
        key = self.source + '_' +self.section
        
        disableCache = True
        if disableCache:
            return self.__download(key)
    
        #First try to load the xml from cache
        
        xml = memcache.get(key)
        
        #If found, return the xml, otherwise download from news provider's rss url
        if xml is not None:
            return xml
        else:
            xml = self.__download(key)
            memcache.add(key,xml,600)
            return xml

    #download from rss    
    def __download(self,key):
        map = { 'dn_top': "http://www.dn.se/m/rss/senaste-nytt",
                'dn_stockholm': "http://www.dn.se/sthlm/m/rss/senaste-nytt",
        
                }
        
        url = map[key]
        try:
            response = urllib2.urlopen(url)
            result = response.read()
            return result
        except urllib2.URLError, e:
            return "error"