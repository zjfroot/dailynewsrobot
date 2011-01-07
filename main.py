#!/usr/bin/env python
#
# Copyright 2010 Jifeng Zhang <zjfroot@gmail.com>.
#
#
import os,sys
import logging

from google.appengine.ext import webapp
from google.appengine.ext.webapp import util
from google.appengine.ext.webapp import template

sys.path.append('modules')

from top import TopNewsHandler

class MainHandler(webapp.RequestHandler):
    def get(self):
        author = 'Jifeng Zhang'
        action = 'programming'
        template_values = {
            'author':author,
            'action':action,
        }
        path = os.path.join(os.path.dirname(__file__),'index.html')
        self.response.out.write(template.render(path,template_values))

def main():
    logging.getLogger().setLevel(logging.DEBUG)
    
    topNewsHandler = TopNewsHandler()

    application = webapp.WSGIApplication([('/', MainHandler),
                                          ('/top', TopNewsHandler),],
                                          debug=True)
    util.run_wsgi_app(application)


if __name__ == '__main__':
    main()