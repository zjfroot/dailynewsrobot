#!/usr/bin/env python
#
# Copyright Jifeng Zhang <zjfroot@gmail.com>.
#
#
from google.appengine.ext import webapp
from google.appengine.ext.webapp import util
from google.appengine.ext.webapp import template

from xmlfetcher import XmlFetcher

class TopNewsHandler(webapp.RequestHandler):
    def get(self):
        fetcher = XmlFetcher("dn","top")
        xml = fetcher.get()
        self.response.headers['Content-Type'] = 'text/xml'
        self.response.out.write(xml)