package com.example.configadapterdemo;

import java.util.List;

/**
 * date：2017/12/28 on 15:47
 * description: 测试数据json，数据源见：textcont.txt文件
 */

public class DataBean {

    /**
     * code : 200
     * msg : success
     * result : {"banner":{"info":"年底大促销","url":["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320355&di=3f137ff3ff2b14841cd17c4135a8e1d4&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F16%2F55%2Fb56519445a1b.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320357&di=49be8eb330e4cafb461b337cecba1e2c&imgtype=0&src=http%3A%2F%2Fpic21.nipic.com%2F20120525%2F7512072_140351788322_2.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg"]},"content":[{"des":"景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。","image":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg","type":"1"},{"des":"景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。","image":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg","type":"1"},{"text":"亚瑟从出生开始就被尤瑟王托付给魔法师梅林抚养，梅林便偷偷将襁褓中的亚瑟带离廷塔杰尔城堡，来到一个隐秘的地方将亚瑟抚养成人，亚瑟王与梅林关系十分良好，传说中梅林可以随意改变自己容貌的年轻或年老，不过他大部分时间都以年迈的老者示人。","type":"2"},{"des":"景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。","image":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg","type":"1"},{"type":"3","url":["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320355&di=3f137ff3ff2b14841cd17c4135a8e1d4&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F16%2F55%2Fb56519445a1b.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320357&di=49be8eb330e4cafb461b337cecba1e2c&imgtype=0&src=http%3A%2F%2Fpic21.nipic.com%2F20120525%2F7512072_140351788322_2.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg"]}]}
     */

    private String code;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * banner : {"info":"年底大促销","url":["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320355&di=3f137ff3ff2b14841cd17c4135a8e1d4&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F16%2F55%2Fb56519445a1b.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320357&di=49be8eb330e4cafb461b337cecba1e2c&imgtype=0&src=http%3A%2F%2Fpic21.nipic.com%2F20120525%2F7512072_140351788322_2.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg"]}
         * content : [{"des":"景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。","image":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg","type":"1"},{"des":"景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。","image":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg","type":"1"},{"text":"亚瑟从出生开始就被尤瑟王托付给魔法师梅林抚养，梅林便偷偷将襁褓中的亚瑟带离廷塔杰尔城堡，来到一个隐秘的地方将亚瑟抚养成人，亚瑟王与梅林关系十分良好，传说中梅林可以随意改变自己容貌的年轻或年老，不过他大部分时间都以年迈的老者示人。","type":"2"},{"des":"景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。","image":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg","type":"1"},{"type":"3","url":["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320355&di=3f137ff3ff2b14841cd17c4135a8e1d4&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F16%2F55%2Fb56519445a1b.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320357&di=49be8eb330e4cafb461b337cecba1e2c&imgtype=0&src=http%3A%2F%2Fpic21.nipic.com%2F20120525%2F7512072_140351788322_2.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg"]}]
         */

        private BannerBean banner;
        private List<ContentBean> content;

        public BannerBean getBanner() {
            return banner;
        }

        public void setBanner(BannerBean banner) {
            this.banner = banner;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class BannerBean {
            /**
             * info : 年底大促销
             * url : ["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320355&di=3f137ff3ff2b14841cd17c4135a8e1d4&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F16%2F55%2Fb56519445a1b.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320357&di=49be8eb330e4cafb461b337cecba1e2c&imgtype=0&src=http%3A%2F%2Fpic21.nipic.com%2F20120525%2F7512072_140351788322_2.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg"]
             */

            private String info;
            private List<String> url;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public List<String> getUrl() {
                return url;
            }

            public void setUrl(List<String> url) {
                this.url = url;
            }
        }

        public static class ContentBean {
            /**
             * des : 景网,全球最大的创意图片库,提供大量免费促销活动图片供用户下载使用,是图片分享和图片交易的专业图片网站。
             * image : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320350&di=338feb36e28738a2383edd39816da05e&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120219%2F5028216_162620696000_2.jpg
             * type : 1
             * text : 亚瑟从出生开始就被尤瑟王托付给魔法师梅林抚养，梅林便偷偷将襁褓中的亚瑟带离廷塔杰尔城堡，来到一个隐秘的地方将亚瑟抚养成人，亚瑟王与梅林关系十分良好，传说中梅林可以随意改变自己容貌的年轻或年老，不过他大部分时间都以年迈的老者示人。
             * url : ["https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320355&di=3f137ff3ff2b14841cd17c4135a8e1d4&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F16%2F55%2Fb56519445a1b.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320357&di=49be8eb330e4cafb461b337cecba1e2c&imgtype=0&src=http%3A%2F%2Fpic21.nipic.com%2F20120525%2F7512072_140351788322_2.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1514463320352&di=671e9cbfeeffcb20af986fe7dee91af5&imgtype=0&src=http%3A%2F%2Fdown1.sucaitianxia.com%2Fpsd02%2Fpsd181%2Fpsds40246.jpg"]
             */

            private String des;
            private String image;
            private String type;
            private String text;
            private List<String> url;

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public List<String> getUrl() {
                return url;
            }

            public void setUrl(List<String> url) {
                this.url = url;
            }
        }
    }
}
