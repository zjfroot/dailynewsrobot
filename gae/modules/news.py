#!/usr/bin/env python
#
# Copyright Jifeng Zhang <zjfroot@gmail.com>.
#
#
from google.appengine.ext import webapp
from google.appengine.ext.webapp import util
from google.appengine.ext.webapp import template

from xmlfetcher import XmlFetcher

class NewsHandler(webapp.RequestHandler):
    def get(self):
        src = self.request.get('src')
        section = self.request.get('sec')
        
        
        fetcher = XmlFetcher(src,section)
        xml = fetcher.get()
        self.response.headers['Content-Type'] = 'text/xml'
        self.response.out.write(xml)