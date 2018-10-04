--缓存抢红包列表信息
local listKey='red_packet_list_'..KEYS[1]

--定义当前被抢红包key
local redPacket='red_packet_'..KEYS[1]

--获取当前红包库存
local stock= tonumber(redis.call('hget',redPacket,'stock'))

redis.log(redis.LOG_NOTICE,stock)

--没有库存，直接返回0
if stock <= 0 then
   return 0
end 

--如果有库存，则减少库存1
stock=stock-1

--保存当前红包库存
redis.call('hset',redPacket,'stock',tostring(stock))

--增加用户抢红包信息
redis.call('rpush',listKey,ARGV[1])

--如果是最后一个红包，返回2，表示抢红包成功，且抢红包结束，需要同步抢红包信息到数据库
if stock==0 then
  return 2 
end

--如果并非是最后一个红包，则返回1，表示抢红包成功
return 1
