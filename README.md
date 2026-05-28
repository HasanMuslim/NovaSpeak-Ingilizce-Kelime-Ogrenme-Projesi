<div align="center">

# 🚀 NovaSpeak

*İngilizceyi Kalıcı Öğren*

</div>

---

> **NovaSpeak**, İngilizce kelimeleri yüzeysel ezberlemek yerine uzun vadede kalıcı biçimde öğretmek amacıyla geliştirilmiş, yapay zekâ destekli bir Android uygulamasıdır. Spaced Repetition (Aralıklı Tekrar) yöntemi, AI entegrasyonu ve oyunlaştırma unsurlarını bir arada sunarak öğrenmeyi hem etkili hem eğlenceli hale getirir.

---

## İçindekiler

- [Öğrenme Sistemi](#️-öğrenme-sistemi)
- [Ekranlar](#️-ekranlar)
- [Yapay Zekâ](#-yapay-zekâ)
- [Teknolojiler](#️-teknolojiler)

---

## ⏱️ Öğrenme Sistemi

Bir kelimenin gerçekten "öğrenilmiş" sayılabilmesi için farklı zaman aralıklarında tekrar tekrar doğru cevaplanması gerekir. NovaSpeak bu amaca yönelik **6 aşamalı Spaced Repetition** döngüsü kullanır:

```
[ 1 Gün ] → [ 1 Hafta ] → [ 1 Ay ] → [ 3 Ay ] → [ 6 Ay ] → [ 1 Yıl ]
```

Tüm aşamaları başarıyla tamamlayan kelime **"kalıcı öğrenildi"** olarak işaretlenir. Herhangi bir aşamada yanlış yanıt verilirse kelime başa döner ve doğru sayısı sıfırlanır; bu sayede sıralama sistemi adil biçimde çalışır.

---

## 🗂️ Ekranlar

### 🏡 Ana Sayfa — `HomePageActivity`

Uygulamanın kullanıcıya ilk gösterilen ana ekranıdır. Kullanıcı burada genel istatistiklerini, yanlış cevapladığı kelimeleri, liderlik sıralamasını ve bazı özel aksiyonları görebilir.

| Bileşen | Açıklama |
|---------|----------|
| 🃏 Slider (ViewFlipper) | Kullanıcıya kelime ekleme, quiz yapma, geri bildirim gönderme ve yapay zekâ ile hikâye oluşturma gibi özellikleri tanıtan görsel kartlar |
| 🥇 Liderlik Tablosu | Firebase üzerinden çekilen kullanıcı verileriyle başarı sıralaması listesi gösterilir; BottomSheet ile açılır |
| 🚫 Yanlış Cevaplar | Son 20 yanlış cevaplanan kelime listesi (aşama = 1 olanlar) kullanıcının tekrar çalışması için gösterilir |
| ✉️ Geri Bildirim | Tek tıklamayla e-posta uygulamasına yönlendirme yapılır |
| 🤖 NovaAI Entegrasyonu | Yapay zekâyla kelimelerden hikâye oluşturma ve görsel üretme özelliğine geçiş sağlanır |
| 🕹️ Mini Oyun | Kullanıcının kelime öğrenimini pekiştirmesi için bulmaca oyununa erişim |

---

### 📖 Sözlük Sayfası

Sisteme eklenen tüm kelimeler **alfabetik sırayla** listelenir. Kullanıcı dilediği kelimeye kolayca ulaşabilir ve detaylarını inceleyebilir.

**Listelenen İçerik:**
- Kelimenin İngilizcesi ve Türkçesi
- İngilizce kelimenin baş harfi (bölüm ayracı olarak gösterilir)

**Arama Özelliği:**
- Hem İngilizce hem de Türkçe kelimeler üzerinden arama yapılabilir
- Kullanıcı, aradığı kelimeyi baş harfine göre filtreleyerek veya arama çubuğunu kullanarak hızlıca bulabilir

**Kelimeye Tıklandığında:**
- Kelimenin Türkçe ve İngilizce karşılığı yan yana gösterilir
- Kelimeye ilişkin görsel görüntülenir
- Kelimenin geçtiği iki adet örnek İngilizce cümle listelenir
- Kelimeye veya cümleye tıklanınca İngilizcesi yüksek sesle okunur; eş zamanlı olarak **Lottie animasyonu** oynar (🎙️ TTS)

---

### ✏️ Kelime Ekleme Sayfası

Kullanıcılar öğrenmek istedikleri kelimeleri sisteme kendileri ekleyebilir. Uygulama yalnızca hazır kelime listeleriyle sınırlı kalmaz; kişisel kelime havuzu oluşturmaya olanak tanır.

Her kelime kaydı aşağıdaki bilgileri içerir:

- Kelimeyi temsil eden görsel
- Kelimenin İngilizcesi ve Türkçe karşılığı
- İngilizce kelimenin kullanıldığı iki adet örnek cümle

---

### 📝 Quiz Sistemi

Quiz ekranı, öğrenilen kelimelerin pekiştirildiği ana pratik alanıdır. Her oturum kullanıcı tercihlerine göre dinamik biçimde şekillenir.

- Firestore'dan **kullanıcının belirlediği kadar kelime** çekilir
- Her kelime için ilgili bir **görsel ve o kelimenin Türkçe karşılığı** gösterilir
- Kullanıcı o an bilmediği kelimeyi atlayabilir ve ilerleyebilir
- Quiz tamamlandıktan sonra yanlış yapılan kelimelere geri dönülerek doğru cevap görülebilir
- Quiz bittiğinde doğru, yanlış ve çözülen toplam soru sayısı özetlenerek gösterilir
- Quizden erken çıkmak istendiğinde onay mekanizması devreye girer

---

### 👤 Profil Sayfası — `ProfileActivity`

Kullanıcıya ait tüm hesap bilgilerinin ve öğrenme ilerlemesinin yönetildiği ekrandır.

**Temel Özellikler:**
- Firebase Authentication ile kullanıcı giriş bilgileri (ad, e-posta, profil fotoğrafı) görüntülenir
- **Admin girişi** için gizli bir kod sistemi içerir
- Kullanıcı ayarları menüsü popup olarak açılır
- Sekmeli yapı: `Quiz Kelimeleri` ve `Öğrenilenler` tabları ayrı ayrı listelenir
- Geri bildirim göndermek için tek tıkla mail uygulamasına yönlendirme yapılır
- Oturum kapatma özelliği bulunur

---

### 🔤 Wordle — Bulmaca Oyunu

Kullanıcıların 5 harfli İngilizce kelimeleri tahmin etmeye çalıştığı interaktif bir bulmaca oyunudur. Wordle'a benzer bir yapıya sahiptir; sınırlı sayıda hak verilir ve doğru tahminlerle skor kazanılır.

**Kelime Kaynakları:**

Oyun başlamadan önce kullanıcı üç farklı kelime havuzundan birini seçebilir:
- **Tüm kelimeler** — veritabanındaki tüm 5 harfli kelimeler
- **Öğrenilmiş kelimeler** — kullanıcının daha önce öğrendiği kelimeler
- **Quiz'de karşılaşılan kelimeler** — daha önce quiz ekranında görülen kelimeler

**Renk Geri Bildirim Sistemi:**

| Renk | Anlam |
|------|-------|
| 🟩 Yeşil | Doğru harf, doğru konum |
| 🟨 Sarı | Doğru harf, yanlış konum |
| ⬛ Gri | Kelimede bulunmayan harf |

**Oyun Özellikleri:**

| Özellik | Detay |
|---------|-------|
| 🎯 Tahmin hakkı | 6 deneme |
| 🧩 Oyun alanı | Grid tabanlı yapı (EditText hücreleriyle) |
| 🔎 İpucu sistemi | Mevcut |
| ⚙️ Ayarlar penceresi | Kelime kaynağı seçimi |
| 📈 Skor takibi | Firebase Authentication ile kullanıcı bazlı kayıt |
| 🔄 Yeni oyun | Buton ile anında yeni oyun başlatılabilir |
| 🔗 Dinamik veri | Firestore üzerinden anlık kelime verisi |

---

### 📊 Raporlama Sayfası — `RaporPage`

Kullanıcının öğrenme sürecini sayısal verilerle takip edebildiği ve bu verileri dışa aktarabildiği ekrandır.

- Kullanıcının toplam doğru ve yanlış cevap sayısını görüntüleme
- Son doğru yanıt verilen tarihi gösterme
- Genel başarı oranı hesaplama ve görselleştirme
- Güncel kullanıcı verilerini Firestore'a güncelleme
- **PDF formatında kişisel öğrenim raporu oluşturma ve paylaşma**

---

## 🤖 Yapay Zekâ

### 🌟 AI Destekli Hikâye Üretimi

Profil ekranından erişilen bu özellik, öğrenilen kelimeleri daha akılda kalıcı hale getirmek için hikâye anlatımını ve görsel üretimi bir araya getirir.

Kullanıcı **5 İngilizce kelime** seçer; sistem bu kelimeleri kullanarak otomatik olarak üretir:

```
Kelimeler  →  Open Router API  →  Özgün İngilizce hikâye
                    ↓
             Pollinations AI   →  Hikâye temasına %100 uygun görsel
```

### 🎙️ Text To Speech (TTS)

Sözlük sayfasında herhangi bir kelimeye veya örnek cümleye tıklandığında:
1. İlgili İngilizce metin **yüksek sesle okunur**
2. Ses çıkışıyla **eş zamanlı olarak Lottie animasyonu** oynar

---

## 🛠️ Teknolojiler

| Katman | Araçlar |
|--------|---------|
| ☁️ Backend | Firebase Authentication · Firebase Firestore · Firebase Storage |
| 🤖 Yapay Zekâ | OpenAI API (GPT-4) · PollinationsAI · Wiro AI |
| 🎙️ Seslendirme | Android TextToSpeech (TTS) |
| 🖌️ UI / UX | Material Design · Lottie Animations · ViewFlipper · BottomSheetDialog · TabLayout · PopupMenu |
| 📱 Android Geliştirme | Kotlin · Android SDK · View Binding · Activity & Fragment yapısı · ViewPager2 |
| 🖼️ Görsel İşleme | Picasso · RoundedCornersTransformation · Lottie |
| 📑 PDF & Raporlama | PdfDocument (Android) · FileProvider · Intent ile dosya paylaşımı |
| 🕹️ Eğitsel Oyun | Özelleştirilmiş Puzzle Game Logic |
| 🗃️ Listeleme | RecyclerView · Custom Adapter |
