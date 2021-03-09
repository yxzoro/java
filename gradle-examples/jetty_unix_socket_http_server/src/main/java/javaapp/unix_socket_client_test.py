# 1.python unix socket client, connect to local jetty.sock, with http protocol.
# Time: 10ms
import requests_unixsocket
import time
session = requests_unixsocket.Session()
url = "http+unix://%2Ftmp%2Fjetty.sock/test"
t1 = time.time()
r = session.get(url)
print(time.time() - t1)
print(r.status_code)
print(r.content)

#TODO: 进程通信，使用unix socket方式和ip:port方式一次请求都是10ms左右，性能并没什么区别 ？？

# 2.http client, connect to http://localhost:port
# Time: 10ms
import requests 
import time
url = "http://localhost:30000/test"
t1 = time.time()
r = requests.get(url)
print(time.time() - t1)
print(r.status_code)
print(r.content)





