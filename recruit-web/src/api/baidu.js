export default {
    init: function () {
      const AK = "TqYwwFNTRV7P6mDcejCVaftVKxJRp1Ua"; //你的AK
      const BMap_URL =
        "https://api.map.baidu.com/api?v=3.0&ak=" +
        AK +
        "&callback=_initBaiduMap";
      return new Promise((resolve, reject) => {
        // 如果已加载直接返回
        if (typeof BMap !== "undefined") {
          resolve(BMap);
          return true;
        }
        // 百度地图异步加载回调处理
        window.onBMapCallback = function () {
          resolve(BMap);
        };
        let getCurrentCityName = function () {
          return new Promise(function (resolve, reject) {
            let myCity = new BMap.LocalCity();
            myCity.get(function (result) {
              resolve(result.name);
            });
          });
        };
        // 插入script脚本
        let scriptNode = document.createElement("script");
        scriptNode.setAttribute(type, "text/javascript");
        scriptNode.setAttribute("src", BMap_URL);
        document.body.appendChild(scriptNode);
      });
    },
  };
  