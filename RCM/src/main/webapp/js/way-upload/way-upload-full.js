WAYUPLOAD = {};
WAYUPLOAD.show = function(b) {
    var a = "/way-upload/upload.html?";
    if (typeof b.path != "undefined") {
        a = b.path + "upload.html?"
    }
    a += "domain=" + document.domain + "&";
    if (typeof b.fileType != "undefined") {
        a += "fileType=" + b.fileType + "&"
    }
    if (typeof b.count != "undefined") {
        a += "count=" + b.count + "&"
    }
    if (typeof b.url != "undefined") {
        a += "url=" + b.url + "&"
    }
    if (typeof b.maxSize != "undefined") {
        a += "maxSize=" + b.maxSize + "&"
    }
    if (typeof b.data != "undefined") {
    	a += "data={";
    	for (var i in b.data) {
    		a += i + ":" + b.data[i] + ",";
    	}
    	a = a.substring(0, a.length - 1);
    	a += "}";
    }
    WAYUPLOAD.box.show(a)
};
WAYUPLOAD.hide = function() {
    WAYUPLOAD.box.hide()
};
WAYUPLOAD.callback = function(a) {};
WAYUPLOAD.box = (function() {
    var c, b, a = 0,
    d, e;
    return {
        show: function(f) {
            e = {
                topsplit: 3,
                iframe: 0
            };
            e.iframe = f;
            c = document.createElement("div");
            b = document.createElement("div");
            a = document.createElement("div");
            d = document.createElement("div");
            b.innerHTML = '<iframe frameborder="0" src="' + e.iframe + '" width="670" height="315" scrolling="no"></iframe>';
            c.appendChild(d);
            c.appendChild(b);
            document.body.appendChild(c);
            document.body.appendChild(a);
            window.onresize = WAYUPLOAD.box.resize;
            WAYUPLOAD.box.addMove();
            c.style.zIndex = "9999";
            c.style.position = "absolute";
            d.style.width = "626px";
            d.style.height = "35px";
            d.style.backgroundColor = "transparent";
            d.style.position = "absolute";
            d.style.left = 0;
            d.style.top = 0;
            d.style.cursor = "move";
            a.style.zIndex = "9998";
            a.style.position = "absolute";
            a.style.top = a.style.left = 0;
            a.style.backgroundColor = "white";
            a.style.opacity = 0.01;
            a.style.filter = "alpha(opacity=1)";
            b.style.height = "315px";
            b.style.width = "670px";
            WAYUPLOAD.box.resize()
        },
        addMove: function() {
            WAYUPLOAD.util.bind(d, "mousedown", h);
            WAYUPLOAD.util.bind(d, "mouseup", g);
            var i, f;
            function h(k) {
                k = WAYUPLOAD.util.getEvent(k);
                i = k.clientX - WAYUPLOAD.util.delPx(c.style.left),
                f = k.clientY - WAYUPLOAD.util.delPx(c.style.top);
                WAYUPLOAD.util.bind(document, "mousemove", j)
            }
            function g() {
                WAYUPLOAD.util.unbind(document, "mousemove", j);
                return false
            }
            function j(k) {
                k = WAYUPLOAD.util.getEvent(k);
                c.style.left = k.clientX - i + "px";
                c.style.top = k.clientY - f + "px";
                return false
            }
        },
        removeMove: function() {
            d.onmousedown = null;
            d.onmouseup = null
        },
        resize: function() {
            WAYUPLOAD.box.pos();
            WAYUPLOAD.box.remask()
        },
        remask: function() {
            a.style.width = WAYUPLOAD.page.swidth() + "px";
            a.style.height = WAYUPLOAD.page.sheight() + "px"
        },
        pos: function() {
            var f;
            if (typeof e.top != "undefined") {
                f = e.top
            } else {
                f = WAYUPLOAD.page.height() / e.topsplit - c.offsetHeight / 2;
                f = f < 20 ? 20 : f
            }
            if (!e.fixed && !e.top) {
                f += WAYUPLOAD.page.top()
            }
            c.style.top = f + "px";
            c.style.left = typeof e.left != "undefined" ? e.left + "px": (WAYUPLOAD.page.width() - c.offsetWidth) / 2 + "px"
        },
        hide: function() {
            this.removeMove();
            c.parentNode.removeChild(c);
            a.style.display = "none"
        }
    }
})();
WAYUPLOAD.page = (function() {
    var e, b, c;
    function a() {
        e = document,
        b = e.documentElement,
        c = e.body;
        return e.compatMode == "BackCompat"
    }
    return {
        top: function() {
            a();
            return Math.max(c.scrollTop, b.scrollTop)
        },
        width: function() {
            return a() ? c.clientWidth: b.clientWidth
        },
        height: function() {
            return a() ? c.clientHeight: b.clientHeight
        },
        swidth: function() {
            return a() ? Math.max(c.clientWidth, c.scrollWidth) : Math.max(b.clientWidth, b.scrollWidth)
        },
        sheight: function() {
            return a() ? Math.max(c.clientHeight, c.scrollHeight) : Math.max(b.clientHeight, b.scrollHeight)
        }
    }
})();
WAYUPLOAD.util = (function() {
    return {
        delPx: function(a) {
            return parseInt(a.substring(0, a.length - 2))
        },
        getEvent: function(a) {
            return a || window.event
        },
        bind: function(b, a, c) {
            if (b.addEventListener) {
                b.addEventListener(a, c, false)
            } else {
                if (b.attachEvent) {
                    b.attachEvent("on" + a, c)
                } else {
                    b["on" + a] = c
                }
            }
        },
        unbind: function(b, a, c) {
            if (b.removeEventListener) {
                b.removeEventListener(a, c, false)
            } else {
                if (b.detachEvent) {
                    b.detachEvent("on" + a, c)
                } else {
                    b["on" + a] = null
                }
            }
        }
    }
})();